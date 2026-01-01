
package ru.avito.feedpro.data.storage

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("settings")

class SettingsDataStore(private val context: Context) {

    private object Keys {
        val COPIES = intPreferencesKey("copies")
        val UNIQUE_LEVEL = intPreferencesKey("unique_level")
        val TEMPLATE = stringPreferencesKey("template")
        val AVITO_TOKEN = stringPreferencesKey("avito_token")
    }

    val settingsFlow: Flow<GeneratorSettings> =
        context.dataStore.data.map { prefs ->
            GeneratorSettings(
                copies = prefs[Keys.COPIES] ?: 1,
                uniqueLevel = prefs[Keys.UNIQUE_LEVEL] ?: 1,
                template = prefs[Keys.TEMPLATE] ?: "",
                avitoToken = prefs[Keys.AVITO_TOKEN]
            )
        }

    suspend fun saveSettings(settings: GeneratorSettings) {
        context.dataStore.edit {
            it[Keys.COPIES] = settings.copies
            it[Keys.UNIQUE_LEVEL] = settings.uniqueLevel
            it[Keys.TEMPLATE] = settings.template
            settings.avitoToken?.let { token ->
                it[Keys.AVITO_TOKEN] = token
            }
        }
    }
}
