package com.insearching.scribbledash.presentation.di


import com.insearching.scribbledash.presentation.DrawingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::DrawingViewModel)
}