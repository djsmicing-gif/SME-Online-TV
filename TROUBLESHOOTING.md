# Troubleshooting Guide

## Build Issues

### Gradle Sync Failed
**Problem**: Gradle files won't sync

**Solutions**:
1. File → Invalidate Caches → Clear Files and Restart
2. Delete `.gradle` folder
3. `./gradlew clean build`
4. Check Gradle version compatibility

### Compilation Errors
**Problem**: Kotlin compilation fails

**Solutions**:
1. Check Kotlin version in `build.gradle.kts`
2. Update Android Studio to latest version
3. Check plugin versions
4. Run `./gradlew clean`

## Runtime Issues

### Blank Screen
**Problem**: App shows blank screen on launch

**Solutions**:
1. Check logcat: `adb logcat | grep SMEOnlineTV`
2. Verify Navigation setup in `MainActivity.kt`
3. Check if composables are rendering
4. Ensure theme is applied

### Crashes on Navigation
**Problem**: App crashes when navigating between screens

**Solutions**:
1. Check navigation route names match
2. Verify NavController initialization
3. Check for null pointer exceptions in logcat
4. Ensure Composables have proper parameters

### Video Player Not Working
**Problem**: ExoPlayer crashes or won't play

**Solutions**:
1. Check video URL is valid
2. Verify internet permission in manifest
3. Check ExoPlayer logs: `adb logcat | grep ExoPlayer`
4. Ensure media format is supported
5. Check for CORS issues with remote streams

## API Issues

### API Endpoints Not Working
**Problem**: Network requests fail

**Solutions**:
1. Check base URL in `RetrofitClient.kt`
2. Verify network connectivity
3. Check API is accessible (curl test)
4. Verify JSON response format
5. Check API key/authentication if needed

### Timeout Errors
**Problem**: Network requests time out

**Solutions**:
1. Increase Retrofit timeout in `RetrofitClient.kt`
2. Check network speed
3. Check API server health
4. Use VPN if API is geo-blocked

## Performance Issues

### Slow Performance
**Problem**: App lags or stutters

**Solutions**:
1. Profile with Android Profiler
2. Check for excessive recompositions
3. Use `remember` for expensive computations
4. Implement `LazyColumn` for lists
5. Reduce image sizes
6. Check memory leaks

### High Memory Usage
**Problem**: App uses excessive memory

**Solutions**:
1. Profile memory with Android Profiler
2. Check for memory leaks
3. Properly dispose resources
4. Release player objects
5. Implement image caching properly

## Device Issues

### App Won't Install
**Problem**: Installation fails on device

**Solutions**:
1. Check device has enough storage
2. Verify app isn't already installed
3. Check Android version compatibility (min 7.0)
4. Try uninstalling previous version
5. Check device developer settings

### Screen Rotation Issues
**Problem**: UI breaks when rotating device

**Solutions**:
1. Test screen rotation in emulator
2. Ensure responsive layout
3. Proper state management across rotations
4. Use `rememberSaveable` for state

## Testing Issues

### Tests Won't Run
**Problem**: Unit or instrumentation tests fail

**Solutions**:
1. Check test dependencies in gradle
2. Verify test file paths
3. Run with: `./gradlew test` or `./gradlew connectedAndroidTest`
4. Check for import errors

## Logging

### Enable Debug Logging
```bash
adb logcat -s SMEOnlineTV
```

### Clear Logcat
```bash
adb logcat -c
```

## Useful Commands

```bash
# Clean build
./gradlew clean build

# Run tests
./gradlew test
./gradlew connectedAndroidTest

# Check dependencies
./gradlew dependencies

# Profile app
./gradlew profileDebugBuild

# Install app
adb install app/build/outputs/apk/debug/app-debug.apk

# View logs
adb logcat

# Clear app data
adb shell pm clear com.smeonlinetv.app
```

## Getting Help

1. Check this troubleshooting guide
2. Review logcat output
3. Check GitHub Issues
4. Visit Android Developer documentation
5. Contact development team
