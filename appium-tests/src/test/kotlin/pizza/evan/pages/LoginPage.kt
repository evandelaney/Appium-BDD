package pizza.evan.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class LoginPage(
    private val driver: AppiumDriver
): Page {

    @iOSXCUITFindBy(accessibility = "username")
    private lateinit var usernameTextField: WebElement

    @iOSXCUITFindBy(accessibility = "password")
    private lateinit var passwordTextField: WebElement

    @iOSXCUITFindBy(accessibility = "login_button")
    private lateinit var loginButton: WebElement

    @iOSXCUITFindBy(accessibility = "close_button")
    private lateinit var closeButton: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    override fun close() {
        closeButton.click()
    }

    fun enterUsername(username: String) {
        usernameTextField.sendKeys(username)
    }

    fun enterPassword(password: String) {
        passwordTextField.sendKeys(password)
    }

    fun tapLogInButton(): HomePage {
        loginButton.click()
        return HomePage(driver)
    }
}
