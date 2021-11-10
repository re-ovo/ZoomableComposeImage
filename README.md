# ZoomableComposeImage
[![](https://jitpack.io/v/re-ovo/ZoomableComposeImage.svg)](https://jitpack.io/#re-ovo/ZoomableComposeImage)
[![GitHub issues](https://img.shields.io/github/issues/re-ovo/ZoomableComposeImage)](https://github.com/re-ovo/ZoomableComposeImage/issues)
[![GitHub stars](https://img.shields.io/github/stars/re-ovo/ZoomableComposeImage)](https://github.com/re-ovo/ZoomableComposeImage/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/re-ovo/ZoomableComposeImage)](https://github.com/re-ovo/ZoomableComposeImage/network)
[![GitHub license](https://img.shields.io/github/license/re-ovo/ZoomableComposeImage)](https://github.com/re-ovo/ZoomableComposeImage)

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
// Example usage
ZoomableImage(
    modifier = your Modifier,
    painter = your painter here (Recommended to use with coil)
)
```