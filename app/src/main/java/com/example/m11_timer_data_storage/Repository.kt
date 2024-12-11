package com.example.m11_timer_data_storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.widget.EditText

private const val PREFERENCE_NAME = "preference_name"
const val SHARED_PREF_KEY = "shared_pref_key"

class Repository(context: Context) {

    private var localValue: String? = ""
    private var prefs: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
    private var editor: Editor = prefs.edit()


    //saveText будет записывать значения и в SharedPreference, и в локальную переменную
    fun saveText(text: String) {
        localValue = text
        editor.putString(SHARED_PREF_KEY, text)
        editor.apply()
    }

    // getDataFromSharedPreference  будет доставать значение из SharedPreference
    private fun getDataFromSharedPreference(): String? {
        return prefs.getString(SHARED_PREF_KEY, null)
    }

    //  getDataFromLocalVariable будет доставать значение, возвращать значение локальной переменной
    private fun getDataFromLocalVariable(): String? {
        val localValueCurrent = localValue
        return localValueCurrent
    }

    //getText будет доставать значение из источников: сначала попытается взять значение локальной переменной;
// если оно null, то попытаемся взять значение из SharedPreference
    fun getText(): String {
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference() != null -> getDataFromSharedPreference()!!
            else -> ""
        }
    }

    //clearText() — будет очищать значение и в SharedPreference, и в локальной переменной.
    fun clearText(int: Int) {
        when (int) {
            0 -> {
                localValue = ""
                editor.remove(SHARED_PREF_KEY)
                editor.apply()
            }
//            1 -> {
//                localValue = null.toString()
//                editor.remove(SHARED_PREF_KEY)
//                editor.apply()
//            }
        }
    }
}
