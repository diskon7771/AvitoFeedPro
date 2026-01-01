
package ru.avito.feedpro.ui.yadisk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.domain.usecase.SyncFeedToYandexDiskUseCase
import javax.inject.Inject

@HiltViewModel
class YandexDiskViewModel @Inject constructor(
    private val syncFeed: SyncFeedToYandexDiskUseCase
) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()

    fun upload(token: String) {
        viewModelScope.launch {
            val result = syncFeed(token)
            _state.value = result.toString()
        }
    }
}
