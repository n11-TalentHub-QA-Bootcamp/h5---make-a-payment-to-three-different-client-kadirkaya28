Feature: feature
  Background:
    Given User in the login page of Eribank Application

  Scenario: Check login with incorrect username and password to the Eribank application
    When User login with incorrect "test" for username and "test" for password
    Then User should see error message

  Scenario:  Check login with correct username and password to the Eribank application
    When User login with correct "company" for username and "company" for password to the Eribank application
    Then User should be taken to the home page
