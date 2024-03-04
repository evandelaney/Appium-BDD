package pizza.evan.utilities

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import java.net.URL

sealed class Platform {

    val appiumServer = URL("http://127.0.0.1:4723")

    abstract fun makeDriver(): AppiumDriver
}

class IosPlatform: Platform() {

    override fun makeDriver(): AppiumDriver {
        val options = XCUITestOptions()
            .setBundleId("pizza.evan.Appium-BDD")
            .setDeviceName("iPhone 15 Pro")
            .setPlatformVersion("17.0")

        return IOSDriver(appiumServer, options)
    }
}

class AndroidPlatform: Platform() {

    override fun makeDriver(): AppiumDriver {
        val options = UiAutomator2Options()
            .setAppPackage("pizza.evan.appium_bdd")
            .setAppActivity("pizza.evan.appium_bdd.MainActivity")

        val driver = AndroidDriver(appiumServer, options)
        driver.setSetting("disableIdLocatorAutocompletion", true)

        return driver
    }
}

fun platformOf(value: String): Platform {
    return if (value.contains("ios", ignoreCase = true)) {
        IosPlatform()
    }
    else {
        AndroidPlatform()
    }
}