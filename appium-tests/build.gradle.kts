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
    testImplementation(libs.bundles.junit)
    testRuntimeOnly(libs.junit.launcher)

    testImplementation(platform(libs.cucumber.bom))
    testImplementation(libs.bundles.cucumber)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }

    // Launch tests with ./gradlew test -Dplatform={ios|android}
    // passing the platform on which you wish to run tests.
    systemProperty("platform", System.getProperty("platform") ?: "ios")
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}
