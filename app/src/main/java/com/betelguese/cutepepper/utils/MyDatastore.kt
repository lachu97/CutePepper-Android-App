package com.betelguese.cutepepper.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyDatastore(context: Context){
    private val ctx=context

    private val Context.dataStore: DataStore<Preferences> by
    preferencesDataStore(name = "Status")
    companion object{
        val KEY= booleanPreferencesKey("isloggedin")
        val EMAIl= stringPreferencesKey("email")
    }
    suspend fun writeemail(value:String){
        ctx.dataStore.edit {
            it[EMAIl]=value
        }
    }
    fun getemail():Flow<String> = ctx.dataStore.data.map {
        it[EMAIl]?:""
    }
    suspend fun writeloggedin(value:Boolean){
        ctx.dataStore.edit {
            it[KEY]=value
        }
    }
    fun getstatus(): Flow<Boolean> = ctx.dataStore.data.map {
        it[KEY]?:false
    }


}