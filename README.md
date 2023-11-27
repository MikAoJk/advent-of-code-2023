# advent-of-code-2023
https://adventofcode.com/2023

## Technologies used
* Kotlin
* Gradle
* JDK 21

## Local development started

### Prerequisites
Make sure you have the Java JDK 21 installed
You can check which version you have installed using this command:
``` bash
java -version
 ```

### Running the application locally

#### Build and run tests
To build locally and run the integration tests you can simply run
``` bash
./gradlew clean build
 ```
or on windows
`gradlew.bat clean build`

### Upgrading the gradle wrapper
Find the newest version of gradle here: https://gradle.org/releases/ Then run this command:

``` bash
./gradlew wrapper --gradle-version $gradleVersjon
```

