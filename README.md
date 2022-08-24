<h1 align="center">MOX Articles</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=23"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.4.xxx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
</p>

## Overview 🕌
An articles app that lets the users read and discovering a lot of topics.
• Home Screen to display the latest of articles.
• Categories screen that includes a lot of major’s articles.
• Save favorite articles with SQLite.
• Apply MVVM Architecture and Databinding.
• Daily Notification to attention the user with new articles and used shortcuts
<br />

## App Images
Top | Pro | Android 
--- | --- | --- | 
![](https://i.ibb.co/qDdH6Z1/Tech.png) | ![](https://i.ibb.co/dbs5NtD/Programming.png) | ![](https://i.ibb.co/191Zpq3/Meduim.png) | 

| Kotlin | UX 
--- | --- |
![](https://i.ibb.co/vJsfXp2/Kotlin.png) | ![](https://i.ibb.co/8P1CYYc/UX.png)
<br />
 
  
## Project Architecture MVVM
![MVVM3](https://user-images.githubusercontent.com/1812129/68319232-446cf900-00be-11ea-92cf-cad817b2af2c.png)
- Yes , liveData is easy , powerful , but you should know how to use.
 - For livedate which will emit data stream , it has to be in your
   data layer , and don't inform those observables any thing else like
   in which thread those will consume , cause it is another
 - For livedata which will emit UI binding events, it has to be in your ViewModel Layer.
 - Observers in UI Consume and react to live data values and bind it.
   responsibility , and according to `Single responsibility principle`
  in `SOLID (object-oriented design)` , so don't break this concept by
   mixing the responsibilities .

  ![mvvm2](https://user-images.githubusercontent.com/1812129/68319008-e9d39d00-00bd-11ea-9245-ebedd2a2c067.png)
<br />
  
  ## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [RxJava](https://github.com/ReactiveX/RxJava) - Java VM implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences.
- [Retrofit](https://github.com/square/retrofit) - A type-safe HTTP client for Android and Kotlin.
- [OkHttp](https://square.github.io/okhttp/) - HTTP is the way modern applications network. It’s how we exchange data & media. Doing HTTP efficiently makes your stuff load faster and saves bandwidth.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
- [Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
<br />

## Contributing 🤝

If you'd like to contribute, please take a look at the [PRs Welcome](https://github.com/MoatazBadawy/MOX_Articles/labels) label on the issue tracker. For new features, please open an issue to discuss it before beginning implementation.

