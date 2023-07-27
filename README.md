MVVM Clean Architecture News app

Structural design pattern:

The app is built with the Model-View-ViewModel (MVVM) is its structural design pattern that separates objects into three distinct groups:

Models hold application data. They’re usually structs or simple classes.
Views display visual elements and controls on the screen. They’re typically subclasses of UIView.
View models transform model information into values that can be displayed on a view. They’re usually classes, so they can be passed around as references.

Tech Stack:-

#Kotlin - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.

#Material 3 - Latest Material design for Android.

Jetpack components:

#Jetpack Compose - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

#Lifecycle - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.

#ViewModel -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.

#Kotlin-Flows - A flow is conceptually a stream of data that can be computed asynchronously.

#Kotlin Coroutines - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.

#Dagger Hilt - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

#Coil- An image loading library for Android backed by Kotlin Coroutines.
