
package ru.avito.feedpro.ui.avito

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.domain.usecase.ConnectAvitoAccountUseCase
import javax.inject.Inject

@HiltViewModel
class AvitoAccountViewModel @Inject constructor(
    private val connectAvito: ConnectAvitoAccountUseCase
) : ViewModel() {

    private val _status = MutableStateFlow("")
    val status = _status.asStateFlow()

    fun connect(token: String) {
        viewModelScope.launch {
            val result = connectAvito(token)
            _status.value = result.toString()
        }
    }
}
