//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import XCTest
import ViewInspector
@testable import Appium_BDD

final class HelloWorldViewTests: XCTestCase {
    
    private var view: HelloWorldView!

    override func setUpWithError() throws
    {
        try super.setUpWithError()
        
        view = HelloWorldView()
    }

    override func tearDownWithError() throws
    {
        view = nil
        
        try super.tearDownWithError()
    }
    
    func test_GreetingLabel_HasExpectedValue() throws
    {
        let greetingText = try view.inspect()
            .find(viewWithAccessibilityIdentifier: "greeting")
            .text()
        
        XCTAssertEqual(try greetingText.string(), "Hello, world!")
    }
    
    func test_IconImage_HasExpectedAccessibilityValue() throws
    {
        let iconImage = try view.inspect()
            .find(viewWithAccessibilityIdentifier: "icon")
            .image()
        
        XCTAssertEqual(try iconImage.actualImage().name(), "globe")
    }
}
