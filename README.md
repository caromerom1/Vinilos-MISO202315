# Vinilos MISO-202315 Grupo 2

## Team Members

- Juan Manuel Jiménez - jm.jimenezc12@uniandes.edu.co

- Andrés Felipe Lombo – a.lombo@uniandes.edu.co

- Juan José Montenegro Pulido - jj.montenegro@uniandes.edu.co

- Camilo Andrés Romero Maldonado – ca.romerom1@uniandes.edu.co

## Execute App

To run the app follow these steps:

- Open the latest available version of Android Studio

- Open `/app/build.gradle.kts` file and ensure all the gradle dependencies of the project are installed and synced

- Select a device that uses Android SDK 21 or higher.

- Select `app` on the `Run / Debug Configurations` dropdown

- Click on `Run app` button

> Note: Take into account that the API is deployed on `render.com` so it is needed to wait until the API is running.
> If the API does not run at all, almost all the views will show an error after the loader stops.
> If after waiting a couple of minutes the API is not running (it happened to us a couple of times), please contact our member `Camilo Andrés Romero Maldonado` who owns the project of the API on render and can redeploy it.

## Execute Tests

To run the tests follow these steps:

- Open the latest available version of Android Studio

- Open `/app/build.gradle.kts` file and ensure all the gradle dependencies of the project are installed and synced

- Open any file containing tests

- Click on the button on the right side of the line number that matches the name of the class that contains tests

## Build App

To build the app follow these steps:

- Open the latest available version of Android Studio

- Open `/app/build.gradle.kts` file and ensure all the gradle dependencies of the project are installed and synced

- Click on `build` menu on the top bar

- Hover on Build bundle(s) / APK(s)

- Click on Build APK(s)

- The APK will appear on the following route `app/build/outputs/apk/debug/app-debug.apk`
