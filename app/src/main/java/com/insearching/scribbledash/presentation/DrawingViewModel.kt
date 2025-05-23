package com.insearching.scribbledash.presentation

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.insearching.scribbledash.utils.FixedSizeQueue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DrawingState(
    val selectedColor: Color = Color.Black,
    val currentPath: PathData? = null,
    val paths: List<PathData> = emptyList(),
    val redoEnabled: Boolean = false,
)

const val UNDO_HISTORY_SIZE = 5

data class PathData(
    val id: String,
    val color: Color,
    val path: List<Offset>,
)

sealed interface DrawingAction {
    data object OnUndoClick : DrawingAction
    data object OnRedoClick : DrawingAction
    data object OnNewPathStart : DrawingAction
    data class OnDraw(val offset: Offset) : DrawingAction
    data object OnPathEnd : DrawingAction
    data class OnSelectColor(val color: Color) : DrawingAction
    data object OnClearCanvasClick : DrawingAction
}

class DrawingViewModel : ViewModel() {

    private val _state = MutableStateFlow(DrawingState())
    val state = _state.asStateFlow()

    val redoPaths = FixedSizeQueue<PathData>(UNDO_HISTORY_SIZE)

    fun onAction(action: DrawingAction) {
        when (action) {
            DrawingAction.OnClearCanvasClick -> onClearCanvasClick()
            is DrawingAction.OnDraw -> onDraw(action.offset)
            DrawingAction.OnNewPathStart -> onNewPathStart()
            DrawingAction.OnPathEnd -> onPathEnd()
            is DrawingAction.OnSelectColor -> onSelectColor(action.color)
            DrawingAction.OnRedoClick -> onRedo()
            DrawingAction.OnUndoClick -> onUndo()
        }
    }

    private fun onSelectColor(color: Color) {
        _state.update {
            it.copy(
                selectedColor = color
            )
        }
    }

    private fun onPathEnd() {
        val currentPathData = state.value.currentPath ?: return
        redoPaths.pop()
        _state.update {
            it.copy(
                currentPath = null,
                paths = it.paths + currentPathData,
                redoEnabled = redoEnabled()
            )
        }
    }

    private fun onNewPathStart() {
        _state.update {
            it.copy(
                currentPath = PathData(
                    id = System.currentTimeMillis().toString(),
                    color = it.selectedColor,
                    path = emptyList()
                )
            )
        }
    }

    private fun onDraw(offset: Offset) {
        val currentPathData = state.value.currentPath ?: return
        _state.update {
            it.copy(
                currentPath = currentPathData.copy(
                    path = currentPathData.path + offset
                )
            )
        }
    }

    private fun onClearCanvasClick() {
        redoPaths.clear()
        _state.update {
            it.copy(
                currentPath = null,
                paths = emptyList(),
                redoEnabled = redoEnabled()
            )
        }
    }

    private fun onUndo() {
        if (state.value.paths.isEmpty()) return

        if (redoPaths.size() == UNDO_HISTORY_SIZE) return

        val path = state.value.paths.last()
        if (state.value.paths.size > 1) {
            redoPaths.add(path)
        }

        _state.update {
            it.copy(
                paths = it.paths - path,
                redoEnabled = redoEnabled() && it.paths.size > 1
            )
        }
    }

    private fun onRedo() {
        if (state.value.paths.isEmpty()) {
            redoPaths.clear()
            return
        }

        redoPaths.pop()?.let { prevPath ->
            _state.update {
                it.copy(
                    paths = it.paths + prevPath,
                    redoEnabled = redoEnabled()
                )
            }
        }
    }

    private fun redoEnabled() = !redoPaths.isEmpty()
}