package pizza.evan.appium

import org.openqa.selenium.WebElement

val WebElement.string: String
    get() {
        return try {
            getAttribute("value") ?: ""
        }
        catch (e: Exception) {
            try {
                getAttribute("label") ?: ""
            }
            catch (e: Exception) {
                getAttribute("text") ?: ""
            }
        }
    }

val WebElement.accessibilityString: String
    get() {
        return try {
            getAttribute("label") ?: ""
        }
        catch (e: Exception) {
            getAttribute("content-desc") ?: ""
        }
    }