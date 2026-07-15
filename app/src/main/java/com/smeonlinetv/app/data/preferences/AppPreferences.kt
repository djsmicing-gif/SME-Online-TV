package com.smeonlinetv.app.data.preferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(
        "SME_ONLINE_TV_PREFS",
        Context.MODE_PRIVATE
    )
    
    var isDarkMode: Boolean
        get() = prefs.getBoolean("dark_mode", true)
        set(value) = prefs.edit().putBoolean("dark_mode", value).apply()
    
    var autoPlayEnabled: Boolean
        get() = prefs.getBoolean("auto_play", true)
        set(value) = prefs.edit().putBoolean("auto_play", value).apply()
    
    var qualityPreference: String
        get() = prefs.getString("quality_preference", "auto") ?: "auto"
        set(value) = prefs.edit().putString("quality_preference", value).apply()
    
    var lastWatchedChannelId: String?
        get() = prefs.getString("last_watched_channel", null)
        set(value) = prefs.edit().putString("last_watched_channel", value).apply()
    
    var lastWatchedVideoId: String?
        get() = prefs.getString("last_watched_video", null)
        set(value) = prefs.edit().putString("last_watched_video", value).apply()
    
    var isUserLoggedIn: Boolean
        get() = prefs.getBoolean("user_logged_in", false)
        set(value) = prefs.edit().putBoolean("user_logged_in", value).apply()
    
    fun clearAll() {
        prefs.edit().clear().apply()
    }
}
