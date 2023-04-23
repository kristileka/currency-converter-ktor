import gradle.kotlin.dsl.accessors._270b9b79ffdd745d3f0e8c11e7ef13de.testImplementation

val mockkVersion: String by rootProject
val koinVersion: String by rootProject
val ktorVersion: String by rootProject
val logbackVersion: String by rootProject
val kotlinVersion: String by rootProject

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
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    testImplementation("io.ktor:ktor-client-content-negotiation:2.1.1")
    testImplementation("io.ktor:ktor-client-json:$ktorVersion")

}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
