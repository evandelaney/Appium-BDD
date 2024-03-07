## How to use
1. Install Appium
2. Install the XCUITest and UiAutomator2 drivers
3. Open Terminal, and start the Appium Server with `appium`

_Test iOS App_

4. Open the Xcode project in the `iOS` directory
5. Build and run `Appium-BDD` to iPhone 15 Pro simulator
6. Choose "Appium Tests" from the schema picker, Cmd+B (Build) will start the Appium tests.

_Test Android App_

7. Open Android Studio, and open the `Android` directory
8. Start an Android emulator
9. Hit Ctrl + Ctrl to open "Run Anything"
10. Type `./gradlew testAppiumTest` and press return

The iOS project has a Page Object Model setup using XCUITest. These have a similar look-and-feel to the Appium tests and are 100% redundant.

The iOS project also has unit tests that use the open source library ViewInspector to make white-box testing assertions against `HelloWorldView`.

## What's next?
Write more Gherkin features for a Login Screen. Three scenarios: (1) tapping login without username and password fails, (2) usernames are validated as emails regex, and (3) passwords must have 8 characters and one must be a number.

Refactor the iOS code to be unit testable.
