package pizza.evan.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class HomePage(
    driver: AppiumDriver
) {

    @iOSXCUITFindBy(accessibility = "title")
    private lateinit var titleLabel: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    val isDisplayed: Boolean
        get() = titleLabel.isDisplayed
}
