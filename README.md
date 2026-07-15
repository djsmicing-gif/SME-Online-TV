# SME Online TV

A modern Android TV streaming application built with Kotlin and Jetpack Compose.

## Features

- **Splash Screen**: Beautiful animated splash screen with app branding
- **Home Screen**: Featured content carousel, trending shows, and personalized recommendations
- **Live TV Page**: Real-time streaming using ExoPlayer with channel listing
- **Videos Page**: Browse and play on-demand video content
- **News Page**: Latest news articles and updates
- **Search Functionality**: Powerful search across all content categories
- **User Profile**: Account management and preferences
- **Bottom Navigation**: Easy navigation between all major sections
- **Dark Theme**: Modern dark theme with blue, black, and white color scheme
- **Android TV Optimized**: Designed specifically for Android TV with touch and remote control support

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Hilt Dependency Injection
- **Media Playback**: Media3/ExoPlayer
- **Navigation**: Jetpack Navigation Compose
- **Image Loading**: Coil
- **Networking**: Retrofit + OkHttp
- **Serialization**: Kotlinx Serialization
- **Local Storage**: Room Database + DataStore
- **Async**: Coroutines
- **TV Support**: AndroidX TV Foundation & Material

## Project Structure

```
app/src/main/
├── kotlin/com/smeonlinetv/app/
│   ├── MainActivity.kt
│   ├── ui/
│   │   ├── theme/
│   │   │   ├── Color.kt
│   │   │   ├── Theme.kt
│   │   │   └── Type.kt
│   │   ├── navigation/
│   │   │   ├── NavDestinations.kt
│   │   │   └── AppNavigation.kt
│   │   ├── screens/
│   │   │   ├── splash/SplashScreen.kt
│   │   │   ├── home/HomeScreen.kt
│   │   │   ├── livetv/LiveTVScreen.kt
│   │   │   ├── videos/VideosScreen.kt
│   │   │   ├── news/NewsScreen.kt
│   │   │   ├── search/SearchScreen.kt
│   │   │   ├── profile/ProfileScreen.kt
│   │   │   └── player/PlayerDetailScreen.kt
│   │   └── components/
│   │       ├── BottomNavigation.kt
│   │       └── FeaturedCarousel.kt
│   └── data/ (for API, Database, Repository)
├── res/
│   ├── values/
│   │   ├── strings.xml
│   │   ├── colors.xml
│   │   └── themes.xml
│   └── mipmap/ (launcher icons)
└── AndroidManifest.xml
```

## Color Scheme

- **Primary**: Blue (#0066CC)
- **Background**: Black (#0F0F0F)
- **Surface**: Dark Gray (#1A1A1A)
- **Text Primary**: White (#FFFFFF)
- **Text Secondary**: Light Gray (#B3B3B3)

## Package Name

`com.smeonlinetv.app`

## Getting Started

### Prerequisites

- Android Studio Iguana or later
- Java 8 or higher
- Android SDK 34+
- Gradle 8.1+

### Installation

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Build and run on an Android TV emulator or device

### Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run tests
./gradlew test

# Run connected tests
./gradlew connectedAndroidTest
```

## Configuration

### TV Support

This app is optimized for Android TV:
- Minimum SDK: 24
- Target SDK: 34
- Supports both touchscreen and remote control navigation
- Hardware touchscreen feature is optional
- Leanback launcher support included

### Permissions

- `android.permission.INTERNET` - For API calls and streaming
- `android.permission.ACCESS_NETWORK_STATE` - For connectivity checks

## Future Enhancements

- [ ] Integration with live TV backend API
- [ ] User authentication system
- [ ] Watch history and bookmarks
- [ ] Recommendation engine
- [ ] Push notifications
- [ ] Casting support (Chromecast)
- [ ] DVR functionality
- [ ] Parental controls
- [ ] Multi-language support
- [ ] Offline playback

## Contributing

Contributions are welcome! Please follow these guidelines:
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, email support@smeonlinetv.com or create an issue in the repository.

## Authors

- **SME Online TV Team**

---

Built with ❤️ for Android TV enthusiasts
