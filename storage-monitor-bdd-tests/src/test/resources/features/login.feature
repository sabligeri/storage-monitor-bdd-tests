Feature: User Login

  Background:
    Given User is registered

  Scenario: Successful login
    When Login page is opened
    And Login with valid credentials
    Then Should be navigated on the home page

  Scenario: Failed login due to invalid credentials
    When Login page is opened
    And Login with username "invalidUser" and password "wrongPassword"
    Then An error message should appear containing "Invalid username or password"

  Scenario: Redirect to register page after click on register here link
    When Login page is opened
    And Click on Register here link
    Then Should be redirected on the register page
