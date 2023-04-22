val mockkVersion: String by rootProject
val koinVersion: String by rootProject
val ktorVersion: String by rootProject
val logbackVersion: String by rootProject

plugins {
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.mockk:mockk:$mockkVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.insert-koin:koin-ktor:$koinVersion")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
