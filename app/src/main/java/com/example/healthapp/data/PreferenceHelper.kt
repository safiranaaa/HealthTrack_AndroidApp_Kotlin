package com.example.healthapp.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("health_app_prefs", Context.MODE_PRIVATE)

    fun savePin(pin: String) {
        sharedPreferences.edit().putString("user_pin", pin).apply()
    }

    fun getPin(): String? {
        return sharedPreferences.getString("user_pin", null)
    }

    fun isPinRegistered(pin: String): Boolean {
        val savedPin = getPin()
        return savedPin == pin
    }

    fun clearData() {
        sharedPreferences.edit().clear().apply()
    }
}

