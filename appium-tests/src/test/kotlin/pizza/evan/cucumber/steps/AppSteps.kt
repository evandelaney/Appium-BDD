package pizza.evan.cucumber.steps

import io.appium.java_client.AppiumDriver
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertTrue
import pizza.evan.pages.AppPage
import pizza.evan.pages.HomePage
import pizza.evan.pages.LoginPage
import pizza.evan.utilities.platformOf

class AppSteps {

    private val driver: AppiumDriver
    private lateinit var app: AppPage
    private lateinit var login: LoginPage
    private lateinit var home: HomePage

    init {
        val platformProperty = System.getProperty("platform") ?: "ios"
        driver = platformOf(platformProperty).makeDriver()
    }

    @Given("I launched the app")
    fun `I launched the app`() {
        app = AppPage
        app.launch(driver)
    }

    @Given("I'm on the login screen")
    fun `I'm on the login screen`() {
        login = app.showLoginPage()
    }

    @Given("I enter the username {string}")
    fun `I enter the username`(username: String) {
        login.enterUsername(username)
    }

    @Given("I enter the password {string}")
    fun `I enter the password`(password: String) {
        login.enterPassword(password)
    }

    @When("I click the login button")
    fun `I click the login button`() {
        home = login.tapLogInButton()
    }

    @Then("I should see the Home Screen")
    fun `I should see the Home Screen`() {
        assertTrue(
            home.isDisplayed
        )
    }
}