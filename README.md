# Jira Time Tacker Pro

or how to make high-quality "every-platform" app

# You can run it on
* Android
* iOS
* Windows
* MacOS
* Linux
* Web, yes

# Shared
* Data Layer
* Domain Layer
* Presentation Layer

### Build and Run Android Application
```shell
./gradlew :composeApp:assembleDebug
```
### Build and Run Desktop (JVM) Application
```shell
./gradlew :composeApp:run
```

### Build and Run Web Application
```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.