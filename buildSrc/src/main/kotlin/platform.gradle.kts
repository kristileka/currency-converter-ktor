import gradle.kotlin.dsl.accessors._8031e8204a17d8ab5c478cc96d740be9.implementation
import org.gradle.kotlin.dsl.application
import org.gradle.kotlin.dsl.provideDelegate

val koinVersion: String by rootProject
val ktorVersion: String by rootProject

plugins {
    application
    id("common")
}
dependencies {
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
}
