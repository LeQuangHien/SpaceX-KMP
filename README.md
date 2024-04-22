# Kotlin Multiplatform Mobile (KMM) - Business Logic Sharing

![GitHub repo size](https://img.shields.io/github/repo-size/LeQuangHien/MyKMM)
![GitHub contributors](https://img.shields.io/github/contributors/LeQuangHien/MyKMM)
![GitHub stars](https://img.shields.io/github/stars/LeQuangHien/MyKMM?style=social)
![GitHub forks](https://img.shields.io/github/forks/LeQuangHien/MyKMM?style=social)

This Kotlin Multiplatform Mobile (KMM) project enables business logic sharing between Android and iOS platforms while allowing native UI development using Jetpack Compose for Android and SwiftUI for iOS. Each platform also has its own ViewModel for platform-specific logic. Key technologies include Ktor for networking, Kotlin Coroutines for asynchronous programming, Koin for Dependency Injection, MockK for unit testing, and Mockative for iOS mocking.

## Features

- Business logic sharing between Android and iOS
- Native UI development with Jetpack Compose (Android) and SwiftUI (iOS)
- Separate ViewModels for Android and iOS platforms
- Networking with Ktor
- Asynchronous programming with Kotlin Coroutines
- Dependency Injection with Koin
- Unit testing with MockK
- iOS mocking with Mockative

## Installation

1. Clone this repository.
2. Open the project in Android Studio for Android development or Xcode for iOS development.
3. Build and run the project on an Android emulator or physical device, or an iOS simulator or physical device.

## Usage

- Develop and maintain shared business logic in the `shared` module.
- Implement platform-specific UIs using Jetpack Compose (Android) or SwiftUI (iOS).
- Utilize platform-specific ViewModels for any platform-specific logic.
- Test shared and platform-specific code accordingly.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any bugs or feature requests.

## License

This project is licensed under the Apache-2.0 License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [SwiftUI](https://developer.apple.com/xcode/swiftui/)
- [Ktor](https://ktor.io/)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Koin](https://insert-koin.io/)
- [MockK](https://github.com/mockk/mockk)
- [Mockative](https://github.com/mockative/mockative)
