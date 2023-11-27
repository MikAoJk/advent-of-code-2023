group = "io.github.MikAoJk"
version = "1.0.0"

val kotlinVersion = "1.9.21"
val javaVersion = JavaVersion.VERSION_21

plugins {
    kotlin("jvm") version "1.9.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
}

tasks {

    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }

}