
package ru.avito.feedpro.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.data.storage.SettingsDataStore
import ru.avito.feedpro.data.storage.GeneratorSettings
import ru.avito.feedpro.domain.usecase.GenerateAdTextsUseCase
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStore: SettingsDataStore,
    private val generateAdTexts: GenerateAdTextsUseCase
) : ViewModel() {

    private val _preview = MutableStateFlow("")
    val preview = _preview.asStateFlow()

    fun updateSettings(settings: GeneratorSettings) {
        viewModelScope.launch {
            dataStore.saveSettings(settings)
        }
    }

    fun generatePreview(template: String) {
        viewModelScope.launch {
            val result = generateAdTexts(template, 1, 2)
            if (result is ru.avito.feedpro.domain.util.Result.Success) {
                _preview.value = result.data.firstOrNull()?.description.orEmpty()
            }
        }
    }
}
