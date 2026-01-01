
package ru.avito.feedpro.ui.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.avito.feedpro.domain.model.PhotoAsset
import ru.avito.feedpro.domain.usecase.UniquePhotosUseCase
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val uniquePhotos: UniquePhotosUseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<PhotoAsset>>(emptyList())
    val photos = _photos.asStateFlow()

    fun addPhotos(list: List<PhotoAsset>) {
        _photos.value = _photos.value + list
    }

    fun process() {
        viewModelScope.launch {
            val result = uniquePhotos(_photos.value)
            if (result is ru.avito.feedpro.domain.util.Result.Success) {
                _photos.value = result.data
            }
        }
    }
}
