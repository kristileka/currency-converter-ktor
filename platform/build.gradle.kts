val koinVersion: String by rootProject
val mockkVersion: String by rootProject


plugins {
    id("platform")
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
}