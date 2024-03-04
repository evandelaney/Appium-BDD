package pizza.evan.tests

import io.appium.java_client.AppiumDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import pizza.evan.pages.HelloWorldPage
import pizza.evan.utilities.platformOf

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloWorldPageTests {

    private val driver: AppiumDriver
    private val helloWorldPage: HelloWorldPage

    init {
        val platformProperty = System.getProperty("platform")
        driver = platformOf(platformProperty).makeDriver()
        helloWorldPage = HelloWorldPage(driver)
    }

    @AfterAll
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun `inspect the greeting`() =
        Assertions.assertEquals(
            "Hello, world!",
            helloWorldPage.greetingText
        )

    @Test
    fun `inspect the icon`() =
        Assertions.assertEquals(
            "Globe",
            helloWorldPage.iconAccessibilityText
        )
}