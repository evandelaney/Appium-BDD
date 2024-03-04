//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import XCTest

final class HelloWorldPage {
    
    private let greetingLabel: XCUIElement
    
    private let iconImage: XCUIElement
    
    var greetingText: String {
        greetingLabel.label
    }
    
    var iconAccessibilityText: String {
        iconImage.label
    }
    
    init(app: XCUIApplication)
    {
        greetingLabel = app.staticTexts["greeting"]
        iconImage = app.images["icon"]
    }
}

