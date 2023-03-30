# Burmese Sign Language App

## How to run
1. Clone the project
2. Open the project in Android Studio
3. Wait for Gradle to complete project import and sync
4. Choose `app` module and click run

![How to Run](/media/how_to_1.png)

# Demo
![Demo](/media/demo.gif)

## Stack
- Jetpack Compose UI
- Jetpack Navigation Compose
- Coil
- Accompanist
- Hilt Dependency Injection

## Architecture
- MVVM Architecture
- Multi-module Setup (`app` + `dictionary` module)
- Data supported by [`dictionary.json`](/dictionary/src/main/res/raw/dictionary.json)

App uses MVVM for presentation logic. Dictionary data is supported by local resource [`dictionary.json`](/dictionary/src/main/res/raw/dictionary.json). To support usage of the dictionary offline, we packaged all the required graphical assets into the App. The resources are resolved at runtime by matching the names specified in `dictionary.json` file. 
