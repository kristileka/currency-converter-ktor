import gradle.kotlin.dsl.accessors._8031e8204a17d8ab5c478cc96d740be9.implementation

val ktorVersion: String by rootProject
plugins {
    id("common")
    `java-library`
}
repositories {
    mavenLocal()

}
dependencies {
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

}