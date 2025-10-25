# Jira Time Tacker Pro

or how to make high-quality multiplatform app

[![Wakatime](https://wakatime.com/badge/user/dc8d687f-af52-4c4e-9521-117e01f124aa/project/ef1f5335-25ec-4b8d-ab57-77e3016475e9.svg)](https://wakatime.com/badge/user/dc8d687f-af52-4c4e-9521-117e01f124aa/project/ef1f5335-25ec-4b8d-ab57-77e3016475e9)

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

# Libraries
* Ktor (mp)
* SQLDelight (mp)

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
Add to `Other Linker Flags`: `-lsqlite3`

### TODO:
* one instance can share credentials to other instance via qr
* modularize