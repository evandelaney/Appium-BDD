//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import XCTest

final class HelloWorldPageTests: XCTestCase {

    private var app: XCUIApplication!
    private var helloWorldPage: HelloWorldPage!
    
    override func setUpWithError() throws
    {
        try super.setUpWithError()
        
        continueAfterFailure = false
        
        app = XCUIApplication()
        app.launch()
        
        helloWorldPage = HelloWorldPage(app: app)
    }

    override func tearDownWithError() throws
    {
        app = nil
        helloWorldPage = nil
        
        try super.tearDownWithError()
    }

    func test_InspectTheGreeting() throws
    {
        XCTAssertEqual(helloWorldPage.greetingText, "Hello, world!")
    }
    
    func test_InspectTheIcon() throws
    {
        XCTAssertEqual(helloWorldPage.iconAccessibilityText, "Globe")
    }
}
