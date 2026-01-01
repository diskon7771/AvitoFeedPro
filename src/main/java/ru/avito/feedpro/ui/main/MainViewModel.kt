
package ru.avito.feedpro.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.domain.usecase.GenerateAdTextsUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val generateAdTexts: GenerateAdTextsUseCase
) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun startGeneration(template: String, count: Int) {
        viewModelScope.launch {
            _loading.value = true
            generateAdTexts(template, count, 2)
            _loading.value = false
        }
    }
}
