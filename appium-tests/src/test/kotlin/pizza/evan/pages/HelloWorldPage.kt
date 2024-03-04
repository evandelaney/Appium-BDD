package pizza.evan.pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import pizza.evan.appium.accessibilityString
import pizza.evan.appium.string

class HelloWorldPage(
    driver: AppiumDriver
) {

    @iOSXCUITFindBy(accessibility = "greeting")
    @AndroidFindBy(id = "greeting")
    private lateinit var greetingLabel: WebElement

    @iOSXCUITFindBy(accessibility = "icon")
    @AndroidFindBy(id = "icon")
    private lateinit var iconImage: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    val greetingText: String
        get() = greetingLabel.string

    val iconAccessibilityText: String
        get() = iconImage.accessibilityString
}
