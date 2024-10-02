//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import XCTest
import SwiftUI
import ViewInspector
@testable import Appium_BDD

final class HelloWorldViewTests: XCTestCase {
    
    private var view: (any View)!

    override func setUp() async throws
    {
        try await super.setUp()
        
        let state = AppState()
        view = await HelloWorldView().environmentObject(state)
    }

    override func tearDown() async throws
    {
        view = nil
        
        try await super.tearDown()
    }
    
    func test_GreetingLabel_HasExpectedValue() throws
    {
        let greetingText = try view
            .inspect()
            .find(viewWithAccessibilityIdentifier: "greeting")
            .text()
        
        XCTAssertEqual(try greetingText.string(), "Hello, world!")
    }
    
    func test_IconImage_HasExpectedAccessibilityValue() throws
    {
        let iconImage = try view
            .inspect()
            .find(viewWithAccessibilityIdentifier: "icon")
            .image()
        
        XCTAssertEqual(try iconImage.actualImage().name(), "globe")
    }
}
