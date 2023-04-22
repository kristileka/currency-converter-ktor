val koinVersion: String by rootProject
val mockkVersion: String by rootProject

plugins {
    id("web-services")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    implementation("io.ktor:ktor-client-cio-jvm:2.2.4")
    implementation("io.ktor:ktor-client-logging-jvm:2.2.4")
}