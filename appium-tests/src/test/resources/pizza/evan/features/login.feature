Feature: Login

  Scenario: Successful Login
    Given I launched the app
    And I'm on the login screen
    And I enter the username "test@test.com"
    And I enter the password "password123"
    When I click the login button
    Then I should see the Home Screen