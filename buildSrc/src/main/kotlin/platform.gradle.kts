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
}