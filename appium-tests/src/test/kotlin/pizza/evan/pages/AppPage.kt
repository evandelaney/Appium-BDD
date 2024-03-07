package pizza.evan.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import kotlin.math.log

object AppPage {

    private lateinit var driver: AppiumDriver

    @iOSXCUITFindBy(accessibility = "Appium-BDD")
    private lateinit var appElement: WebElement

    private var pageStack: MutableList<Page> = mutableListOf()

    val isVisible: Boolean
        get() = appElement.isDisplayed

    fun launch(driver: AppiumDriver) {
        this.driver = driver
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
        pageStack.add(HelloWorldPage(driver))
    }

    fun quit() {
        driver.quit()
    }

    fun showHelloWorld(): HelloWorldPage {
        while (pageStack.isNotEmpty() && pageStack.last() !is HelloWorldPage) {
            val page = pageStack.removeLast()
            page.close()
        }

        return pageStack.last() as HelloWorldPage
    }

    fun showLoginPage(): LoginPage {
        return (pageStack.lastOrNull() as? LoginPage ?: showHelloWorld().tapNextButton().let { LoginPage(driver) })
            .also { pageStack.add(it) }
    }
}