# SME Online TV - Android Application

A modern Android application built with Jetpack Compose and Material 3 for streaming live TV, videos, and news content.

## Features

✨ **Core Features:**
- 🎬 **Splash Screen** - Animated splash screen on app startup
- 🏠 **Home Screen** - Featured content and recommendations
- 📺 **Live TV** - ExoPlayer integration for live streaming
- 🎥 **Videos** - Browse and watch on-demand videos
- 📰 **News** - Latest news and updates
- 🔍 **Search** - Find videos and news content
- 👤 **User Profile** - User account and preferences
- 🧭 **Bottom Navigation** - Easy navigation between screens

💎 **Technical Stack:**
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Design System:** Material 3
- **Architecture:** MVVM with Hilt Dependency Injection
- **Video Playback:** ExoPlayer (Media3)
- **Networking:** Retrofit + OkHttp
- **Image Loading:** Coil
- **Local Database:** Room
- **Data Persistence:** DataStore
- **Asynchronous:** Coroutines

🎨 **Theme:**
- Dark theme (Blue, Black, White color scheme)
- Light theme support
- System theme integration

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/smeonlinetv/app/
│   │   │   ├── MainActivity.kt
│   │   │   ├── SMEOnlineTVApp.kt
│   │   │   ├── navigation/
│   │   │   │   ├── Screen.kt
│   │   │   │   └── SMENavigation.kt
│   │   │   ├── ui/
│   │   │   │   ├── screens/
│   │   │   │   │   ├── SplashScreen.kt
│   │   │   │   │   ├── HomeScreen.kt
│   │   │   │   │   ├── LiveTVScreen.kt
│   │   │   │   │   ├── VideosScreen.kt
│   │   │   │   │   ├── NewsScreen.kt
│   │   │   │   │   ├── SearchScreen.kt
│   │   │   │   │   └── ProfileScreen.kt
│   │   │   │   ├── components/
│   │   │   │   │   └── BottomNavigationBar.kt
│   │   │   │   └── theme/
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   └── xml/
│   │   │       ├── backup_schemes.xml
│   │   │       └── data_extraction_rules.xml
│   │   └── AndroidManifest.xml
│   └── test/
│       └── java/com/smeonlinetv/app/
│
├── build.gradle.kts
└── proguard-rules.pro
```

## Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 17 or later
- Kotlin 1.9.20 or later
- Android SDK 24 or later

### Installation

1. Clone the repository
```bash
git clone https://github.com/djsmicing-gif/SME-Online-TV.git
cd SME-Online-TV
```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

## Dependencies

### UI & Compose
- `androidx.compose.ui:ui`
- `androidx.compose.material3:material3`
- `androidx.compose.material:material`
- `androidx.navigation:navigation-compose`

### Media
- `androidx.media3:media3-exoplayer` (ExoPlayer)
- `io.coil-kt:coil-compose` (Image Loading)

### Architecture
- `com.google.dagger:hilt-android` (Dependency Injection)
- `androidx.lifecycle:lifecycle-viewmodel-compose`

### Networking
- `com.squareup.retrofit2:retrofit`
- `com.squareup.okhttp3:okhttp`

### Local Database
- `androidx.room:room-runtime`
- `androidx.datastore:datastore-preferences`

### Async
- `org.jetbrains.kotlinx:kotlinx-coroutines-android`

## Building

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

## Future Enhancements

- [ ] Integrate real backend API
- [ ] Implement user authentication
- [ ] Add playlist management
- [ ] Push notifications
- [ ] Offline download support
- [ ] Advanced search with filters
- [ ] User watchlist and recommendations
- [ ] Social sharing features
- [ ] Multi-language support
- [ ] Performance optimization

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

SME Online TV Development Team

## Support

For issues and questions, please open an issue on GitHub.
