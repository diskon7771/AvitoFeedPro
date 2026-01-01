
package ru.avito.feedpro.ui.ready

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.domain.usecase.ValidateAndUploadFeedUseCase
import javax.inject.Inject

@HiltViewModel
class ReadyPhotosViewModel @Inject constructor(
    private val validateAndUpload: ValidateAndUploadFeedUseCase
) : ViewModel() {

    private val _state = MutableStateFlow("Ожидание")
    val state = _state.asStateFlow()

    fun upload() {
        viewModelScope.launch {
            _state.value = "Проверка фида..."
            val result = validateAndUpload()
            _state.value = result.toString()
        }
    }
}
