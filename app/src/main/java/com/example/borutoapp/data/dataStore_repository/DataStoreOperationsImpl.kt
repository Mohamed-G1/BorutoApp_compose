package com.example.borutoapp.data.dataStore_repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.borutoapp.domain.repository.DataStoreOperations
import com.example.borutoapp.utils.Constants.ONBOARDING_KEY
import com.example.borutoapp.utils.Constants.PREFERENCES_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_KEY)

class DataStoreOperationsImpl(
    context: Context
) : DataStoreOperations {

    private val dataStore = context.dataStore

    object PreferencesKeys {
        val onBoardingKey = booleanPreferencesKey(name = ONBOARDING_KEY)
    }

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map { preferences ->
                val onBoardingValue = preferences[PreferencesKeys.onBoardingKey] ?: false
                onBoardingValue
            }
    }
}