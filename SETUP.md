# Android Studio Project Setup Instructions

## Prerequisites
- Android Studio Hedgehog or later
- JDK 8 or later
- Android SDK 34 (Android 14)
- Gradle 8.1.2

## Project Setup Steps

### 1. Open Project in Android Studio
```bash
cd SME-Online-TV
```

### 2. Sync Gradle Files
- Android Studio will automatically prompt to sync Gradle files
- Or manually: File → Sync Now

### 3. Build the Project
```bash
./gradlew build
```

### 4. Run on Emulator or Device
- Connect Android device or start emulator
- Click "Run" button or: `./gradlew installDebug`

## Project Architecture

### MVVM Pattern
- **Models**: Data classes in `data/model/`
- **Views**: Composable functions in `ui/screens/`
- **ViewModels**: State management in `ui/viewmodel/`

### Dependency Injection
- Uses Koin for lightweight DI
- Configuration in `AppModule.kt`
- Injected into Composables using `@Composable` with `koinInject()`

### Data Layer
- **Repository Pattern**: Data abstraction in `data/repository/`
- **API Service**: Retrofit for HTTP in `data/api/`
- **Local Storage**: Room database in `data/local/`

### UI Layer
- **Material 3**: Latest Material Design components
- **Jetpack Compose**: Declarative UI framework
- **Navigation**: Type-safe navigation with Compose

## Folder Structure

```
app/
├── src/main/
│   ├── java/com/smeonlinetv/app/
│   │   ├── data/
│   │   │   ├── api/
│   │   │   │   ├── APIService.kt
│   │   │   │   └── RetrofitClient.kt
│   │   │   ├── local/
│   │   │   │   └── AppDatabase.kt
│   │   │   ├── model/
│   │   │   │   └── Models.kt
│   │   │   └── repository/
│   │   │       ├── ChannelRepository.kt
│   │   │       ├── VideoRepository.kt
│   │   │       ├── NewsRepository.kt
│   │   │       └── UserRepository.kt
│   │   ├── ui/
│   │   │   ├── components/
│   │   │   │   ├── Cards.kt
│   │   │   │   └── Navigation.kt
│   │   │   ├── screens/
│   │   │   │   ├── SplashScreen.kt
│   │   │   │   ├── MainScreens.kt
│   │   │   │   ├── DetailedScreens.kt
│   │   │   │   └── AdvancedScreens.kt
│   │   │   ├── theme/
│   │   │   │   ├── Color.kt
│   │   │   │   ├── Type.kt
│   │   │   │   └── Theme.kt
│   │   │   └── viewmodel/
│   │   │       ├── ChannelViewModel.kt
│   │   │       ├── VideoViewModel.kt
│   │   │       ├── NewsViewModel.kt
│   │   │       └── UserViewModel.kt
│   │   ├── util/
│   │   │   ├── DateUtil.kt
│   │   │   ├── Dimensions.kt
│   │   │   ├── Logger.kt
│   │   │   ├── NetworkUtil.kt
│   │   │   └── StringUtil.kt
│   │   ├── MainActivity.kt
│   │   ├── SMEOnlineTVApp.kt
│   │   └── AppModule.kt
│   ├── res/
│   │   ├── values/
│   │   │   ├── colors.xml
│   │   │   ├── dimens.xml
│   │   │   ├── strings.xml
│   │   │   ├── strings_extended.xml
│   │   │   ├── themes.xml
│   │   │   ├── arrays.xml
│   │   │   ├── integers.xml
│   │   │   └── extended_colors.xml
│   │   ├── values-night/
│   │   │   ├── colors.xml
│   │   │   └── themes.xml
│   │   ├── xml/
│   │   │   ├── backup_rules.xml
│   │   │   └── data_extraction_rules.xml
│   │   ├── mipmap-anydpi-v26/
│   │   ├── mipmap-anydpi-v33/
│   │   └── drawable/
│   └── AndroidManifest.xml
├── build.gradle.kts
├── proguard-rules.pro
└── .gitignore

build.gradle.kts
settings.gradle.kts
.gitignore
README.md
SETUP.md
```

## Key Features Implementation

### 1. Splash Screen
- 2-second animated splash with gradient background
- Transitions to Main Screen after splash time

### 2. Home Screen
- Featured live channels
- Popular videos
- Latest news
- Pull-to-refresh capability (can be added)

### 3. Live TV
- Grid of live channels
- ExoPlayer integration ready
- Stream URL support

### 4. Videos
- Grid of on-demand videos
- Video duration and view count
- Play button overlay

### 5. News
- News articles in list format
- Thumbnail, title, description
- Publication date

### 6. Search
- Global search across all content types
- Real-time filtering
- Organized results by category

### 7. User Profile
- User information display
- Profile picture
- Verification badge
- Settings menu
- Dark mode toggle
- Logout functionality

### 8. Bottom Navigation
- Easy access to main sections
- Active state indication
- Smooth transitions

## Customization

### Adding New Screens
1. Create new Composable in `ui/screens/`
2. Add to Navigation graph in `MainScreens.kt`
3. Add bottom navigation item if needed

### Modifying Colors
- Edit `ui/theme/Color.kt` for theme colors
- Or modify `res/values/colors.xml` for resource colors

### Changing Fonts
- Update `ui/theme/Type.kt`
- Add custom fonts to `res/font/`

### Updating API Endpoints
- Modify `RetrofitClient.kt` BASE_URL
- Update `APIService.kt` endpoints

## Building for Release

```bash
./gradlew bundleRelease
```

## Testing

```bash
./gradlew test
./gradlew connectedAndroidTest
```

## Troubleshooting

### Build Issues
- Clear cache: `./gradlew clean`
- Rebuild: `./gradlew build`
- Invalidate Android Studio cache: File → Invalidate Caches → Clear Files and Restart

### Runtime Issues
- Check logcat for errors: `adb logcat`
- Verify internet connection for API calls
- Ensure API endpoints are accessible

## Dependencies Update

To update dependencies:
1. Check for updates: `./gradlew dependencyUpdates`
2. Update versions in `app/build.gradle.kts`
3. Sync Gradle files

## Support

For issues or questions:
- Check GitHub Issues
- Review project documentation
- Contact development team

## Version Information

- **App Version**: 1.0.0
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Compile SDK**: 34
- **Kotlin**: 1.9.10
- **Gradle**: 8.1.2
