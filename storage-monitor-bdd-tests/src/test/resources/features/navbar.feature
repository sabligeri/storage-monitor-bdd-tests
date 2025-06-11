Feature: Navigation Bar

  Background:
    Given We are on the home page


  Scenario: Navigate through navbar links
    When I click on the "Storage" link
    Then I should be on the "storagelist" page

    When I click on the "Products" link
    Then I should be on the "products" page

    When I click on the "Production" link
    Then I should be on the "production" page

    When I click on the "Home" link
    Then I should be on the "home" page

    Scenario: Toggle between themes
      When I click on the Toggle Theme button
      Then The theme should be "dark"
      When I click on the Toggle Theme button
      Then The theme should be "light"

    Scenario: Toggle Theme button icon change
      When I click on the Toggle Theme button
      Then The Icon should be "LightModeIcon"
      When I click on the Toggle Theme button
      Then The Icon should be "DarkModeIcon"

    Scenario Outline: Logout by using navigation bar's Logout button
      When I click on the Logout button
      Then We should be directed back to the login page
      And We should not be able to access "<path>" path

      Examples:
      |path|
      |home|
      |storagelist|
      |products|
      |production|