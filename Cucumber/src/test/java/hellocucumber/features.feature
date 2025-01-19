Feature: User checks out a product
  Scenario: User checks out a product
    Given user opens the OpenCart main page
    When user presses on MacBook
    And user adds macBook to the cart
    And user navigates to the shopping cart
    Then user should see the checkout page
    And user verifies that MacBook is in the order summary


  Scenario Outline:  Admin changes product price
    Given admin opens admin login page
    When Admin logs in using "<UserName>" and "<Password>"
    And admin navigates to product catalog
    And admin searches for product "<Product>" and adds variant
    And admin presses Data button
    And admin scrolls down and edits the price to "<Price>"
    And admin saves the changes
    Then verify changes in product: "<Product>", changed to price: "<Price>"
    And close the browser


    Examples:
      | UserName | Password | Product | Price |
      | admin    | 12345678 | iMac    | 911   |
      | admin    | 12345678 | iPhone  | 404   |
