# SME Online TV - Development Guide

## Technology Stack

### Frontend
- **Jetpack Compose**: Modern declarative UI framework
- **Material 3**: Latest Material Design components
- **Navigation Compose**: Type-safe navigation
- **Coil**: Image loading and caching

### Backend Integration
- **Retrofit 2**: HTTP client for REST APIs
- **OkHttp 3**: HTTP client with interceptors
- **Gson**: JSON serialization/deserialization

### Media
- **ExoPlayer/Media3**: Advanced media player
  - Supports multiple formats (HLS, DASH, MP4)
  - Hardware acceleration
  - Adaptive bitrate streaming

### Architecture
- **MVVM**: Model-View-ViewModel pattern
- **Repository Pattern**: Data abstraction layer
- **Dependency Injection**: Koin lightweight DI

### Local Storage
- **Room**: Type-safe database abstraction
- **SharedPreferences**: Key-value storage

### Lifecycle
- **Jetpack Lifecycle**: Lifecycle-aware components
- **ViewModel**: UI state management
- **StateFlow**: Reactive state management

## Code Structure

### Data Layer
```
data/
├── api/          # Retrofit services
├── local/        # Room database
├── model/        # Data classes
└── repository/   # Data access layer
```

### UI Layer
```
ui/
├── components/   # Reusable UI components
├── screens/      # Full-screen Composables
├── theme/        # Material 3 theme
└── viewmodel/    # State management
```

### Utilities
```
util/
├── DateUtil.kt       # Date formatting
├── StringUtil.kt     # String utilities
├── NetworkUtil.kt    # Network checks
├── Logger.kt         # Logging
└── Dimensions.kt     # UI dimensions
```

## Adding API Endpoints

### 1. Define API Service
```kotlin
@GET("endpoint")
suspend fun getEndpoint(): List<Data>
```

### 2. Update Repository
```kotlin
class DataRepository(private val apiService: APIService) {
    fun getEndpoint() = apiService.getEndpoint()
}
```

### 3. Create ViewModel
```kotlin
class DataViewModel(private val repository: DataRepository) : ViewModel() {
    val data = MutableStateFlow<List<Data>>()
}
```

### 4. Use in Composable
```kotlin
@Composable
fun DataScreen(viewModel: DataViewModel = koinInject()) {
    val data by viewModel.data.collectAsState()
}
```

## Adding New Screens

### 1. Create Screen Composable
```kotlin
@Composable
fun NewScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Screen content
    }
}
```

### 2. Add to Navigation
```kotlin
NavHost(navController, startDestination = "home") {
    composable("new_screen") { NewScreen(navController) }
}
```

### 3. Add Navigation Item
```kotlin
NavigationBarItem(
    selected = currentRoute == "new_screen",
    onClick = { onNavigate("new_screen") },
    icon = { Icon(Icons.Default.Icon, "Label") },
    label = { Text("Label") }
)
```

## Best Practices

### State Management
- Use `StateFlow` for reactive state
- Scope ViewModels to lifecycle
- Avoid direct Composable state modifications

### Performance
- Use `remember` for computed values
- Implement `LazyColumn`/`LazyRow` for lists
- Avoid recomposition with `.stateIn()`

### Error Handling
- Try-catch in repository layer
- State-based error display
- User-friendly error messages

### Networking
- Implement network checks before API calls
- Use exponential backoff for retries
- Cache responses when applicable

### UI/UX
- Follow Material 3 guidelines
- Maintain consistent spacing (8dp grid)
- Use semantic colors
- Provide loading and error states

## Testing

### Unit Tests
```kotlin
@Test
fun testFunction() {
    // Test implementation
}
```

### Instrumentation Tests
```kotlin
@RunWith(AndroidJUnit4::class)
class ScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
}
```

## Debugging

### Logcat Filtering
```bash
adb logcat | grep "SMEOnlineTV"
```

### Breakpoints
- Set breakpoints in Android Studio
- Debug with device or emulator
- Inspect variables in Variables pane

### Performance Profiling
- Use Android Profiler
- Monitor CPU, Memory, Network
- Profile composable recompositions

## Deployment

### Build Variants
- **Debug**: Full debugging information
- **Release**: Optimized with ProGuard

### Signing
```bash
./gradlew assembleRelease
```

### Play Store
1. Generate signing key
2. Build signed bundle
3. Upload to Play Console

## Common Issues

### Issue: Blank Screen
- Check logcat for crashes
- Verify Navigation setup
- Check composable rendering

### Issue: Slow Performance
- Profile with Android Profiler
- Optimize list rendering
- Reduce recompositions

### Issue: API Errors
- Verify endpoint URLs
- Check network connectivity
- Inspect request/response

## Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material 3 Design](https://m3.material.io/)
- [Android Architecture Guide](https://developer.android.com/architecture)
- [Retrofit Documentation](https://square.github.io/retrofit/)
- [Room Database Guide](https://developer.android.com/training/data-storage/room)
