plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
    google()
}

group = "com.mcd"
version = "1.0-ALPHA"

kotlin {
    jvmToolchain(17)
}

dependencies {
    testImplementation(libs.appium)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.bundles.cucumber)
    testRuntimeOnly(libs.junit.launcher)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }

    // Launch tests with ./gradlew test -Dplatform={ios|android}
    // passing the platform on which you wish to run tests.
    systemProperty("platform", System.getProperty("platform"))
}
