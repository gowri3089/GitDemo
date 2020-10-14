Feature: Netbanking Functionality
  Scenario: Login functionality
    Given User is on login page
    When user enter "gowri" and "pwdishant"
    Then User is displayed with Home page
    And account list displayed are "true"

  Scenario: Login functionality
    Given User is on login page
    When user enter "anand" and "pwdshreya"
    Then User is displayed with Home page
    And account list displayed are "false"