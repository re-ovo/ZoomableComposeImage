# ZoomableComposeImage
A zoomable image for jetpack compose

## Features
* Double click to zoom
* Use gestures to zoom/move pictures

## Setup
1. Open settings.gradle, and add `maven { url 'https://jitpack.io' }` into repositories   
It should looks like this:   
```groovy
   dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
2. Add the dependency in `build.gradle`
```groovy
implementation 'com.github.re-ovo:ZoomableComposeImage:1.0.1'
```
3. Sync the project

## Usage
```kotlin
ZoomableImage(
    modifier = Modifier.size(200.dp).background(Color.Black),
    painter = your painter here
)
```