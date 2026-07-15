# SME Online TV - Complete Android Project

A modern Android TV streaming application built with Jetpack Compose, Material 3, and ExoPlayer.

## Features

- **Splash Screen**: Beautiful animated splash screen with gradient background
- **Home Screen**: Featured, popular, and recommended content
- **Live TV**: Stream live channels using ExoPlayer
- **Videos**: Browse and watch on-demand videos
- **News**: Latest news and articles
- **Search**: Global search across channels, videos, and news
- **User Profile**: User profile management and preferences
- **Bottom Navigation**: Easy navigation between main sections
- **Dark Theme**: Blue, black, and white color scheme
- **Material 3**: Latest Material Design 3 components
- **Kotlin**: 100% Kotlin codebase
- **Jetpack Compose**: Modern declarative UI framework

## Project Structure

```
app/
├── src/main/
│   ├── java/com/smeonlinetv/app/
│   │   ├── MainActivity.kt
│   │   ├── SMEOnlineTVApp.kt
│   │   ├── AppModule.kt
│   │   ├── ui/
│   │   │   ├── screens/
│   │   │   │   ├── SplashScreen.kt
│   │   │   │   ├── MainScreens.kt
│   │   │   │   └── components/
│   │   │   └── theme/
│   │   │       ├── Color.kt
│   │   │       ├── Type.kt
│   │   │       └── Theme.kt
│   │   └── data/
│   │       ├── model/
│   │       │   └── Models.kt
│   │       └── repository/
│   │           ├── ChannelRepository.kt
│   │           ├── VideoRepository.kt
│   │           ├── NewsRepository.kt
│   │           └── UserRepository.kt
│   ├── res/
│   │   ├── values/
│   │   │   ├── strings.xml
│   │   │   ├── colors.xml
│   │   │   ├── themes.xml
│   │   │   ├── dimens.xml
│   │   │   └── arrays.xml
│   │   ├── values-night/
│   │   │   ├── colors.xml
│   │   │   └── themes.xml
│   │   ├── xml/
│   │   │   ├── backup_rules.xml
│   │   │   └── data_extraction_rules.xml
│   │   ├── mipmap/
│   │   └── drawable/
│   └── AndroidManifest.xml
├── build.gradle.kts
└── proguard-rules.pro
```

## Tech Stack

- **Kotlin**: Modern programming language for Android
- **Jetpack Compose**: Modern declarative UI framework
- **Material 3**: Latest Material Design components
- **Navigation Compose**: Type-safe navigation with Compose
- **ExoPlayer**: Powerful media player for streaming
- **Retrofit 2**: REST API client
- **OkHttp3**: HTTP client
- **Gson**: JSON serialization/deserialization
- **Coil**: Image loading library
- **Koin**: Lightweight dependency injection
- **Room**: Local database
- **Jetpack Lifecycle**: Lifecycle-aware components

## Dependencies

### Core Android
- androidx.core:core-ktx:1.12.0
- androidx.lifecycle:lifecycle-runtime-ktx:2.6.2
- androidx.activity:activity-compose:1.8.0

### Compose
- androidx.compose.ui:ui
- androidx.compose.material3:material3:1.1.1
- androidx.compose.material:material-icons-extended
- androidx.navigation:navigation-compose:2.7.4

### Media
- androidx.media3:media3-exoplayer:1.1.1
- androidx.media3:media3-ui:1.1.1

### Networking
- com.squareup.retrofit2:retrofit:2.9.0
- com.squareup.okhttp3:okhttp:4.11.0

### Image Loading
- io.coil-kt:coil-compose:2.4.0

### Dependency Injection
- io.insert-koin:koin-android:3.4.0
- io.insert-koin:koin-androidx-compose:3.4.0

### Database
- androidx.room:room-runtime:2.6.1
- androidx.room:room-ktx:2.6.1

## Build Information

- **Target SDK**: 34
- **Min SDK**: 24 (Android 7.0)
- **Compile SDK**: 34 (Android 14)
- **Kotlin Version**: 1.9.10
- **Gradle Version**: 8.1.2

## Color Scheme

### Dark Theme
- Primary: #1E88E5 (Blue)
- Secondary: #42A5F5 (Light Blue)
- Tertiary: #0D47A1 (Dark Blue)
- Background: #121212 (Dark)
- Surface: #1E1E1E (Darker Surface)

## Getting Started

1. Clone the repository
2. Open the project in Android Studio Hedgehog or later
3. Sync Gradle files
4. Build and run on an emulator or device

## Version

- **App Version**: 1.0.0
- **Build Version**: 1
- **Package**: com.smeonlinetv.app

## Author

SME Online TV Team

## License

Copyright © 2024. All rights reserved.
