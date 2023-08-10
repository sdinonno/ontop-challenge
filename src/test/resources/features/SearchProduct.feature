@regression @products
Feature: Products - Search and verify product details

  Background:
    Given the user is in the Home page

  Scenario Outline: User selects two products by position and compares them
    Given the user performs a search with keywords "<keywords>"
      And the user verifies the results are displayed with relevant products
    When the user opens product listed in the position "<firstPosition>"
      And the user validates the product details
      And the user navigates back
      And the user opens product listed in the position "<secondPosition>"
      And the user validates the product details
    Then the user validates the products are different
    Examples:
      | keywords    | firstPosition | secondPosition |
      | iPhone 12   | 1             | 3              |