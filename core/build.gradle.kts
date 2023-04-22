plugins {
    id("common")
}

repositories {
    mavenLocal()
}
dependencies {
    api(project(":web-services"))
}