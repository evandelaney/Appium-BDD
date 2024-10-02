package pizza.evan.appium

import org.openqa.selenium.WebElement
import javax.naming.directory.NoSuchAttributeException

/**
 * Provides the text string for a web element
 * @returns the attribute "value" for Apple elements and "text" for Android elements
 */
val WebElement.string: String
    get() {
        return if (isApple) {
            getAttribute("value")
        }
        else {
            getAttribute("text")
        }
    }

/**
 * Provides the accessibility string for a web element
 * @returns the attribute "label" for Apple elements and "content-desc" for Android elements
 */
val WebElement.accessibilityString: String
    get() {
        return if (isApple) {
            getAttribute("label") ?: ""
        }
        else {
            getAttribute("content-desc") ?: ""
        }
    }

/**
 * Determines if a UI element is from an Apple platform
 * @returns true when the attribute "type" contains "XCUIElementType"
 */
val WebElement.isApple: Boolean
    get() {
        try {
            val type = getAttribute("type")
            return type.contains("xcuielementtype", ignoreCase = true)
        } catch (e: Exception) {
            return false
        }
    }
