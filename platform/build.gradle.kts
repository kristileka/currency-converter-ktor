val ktorVersion: String by rootProject
val koinVersion: String by rootProject

plugins {
    id("platform")
    id("org.jetbrains.kotlin.plugin.serialization")
}
group = "platform"
version = "0.0.1"
application {
    mainClass.set("platform.ApplicationKT")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("io.insert-koin:koin-ktor:$koinVersion")
    implementation("io.ktor:ktor-server-request-validation:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
}
