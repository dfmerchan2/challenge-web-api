Feature: Purchasing products on SauceDemo

  I as a SauceDemo user
  I want to add products to cart
  To purchase these

  Scenario: Buy a product successfully
    Given that "Diego" authenticates with user "standard_user" and password "secret_sauce"
    When add the products to the shopping cart
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |
      | Sauce Labs Backpack   |
    And carry out the checkout process
    Then should see the message "THANK YOU FOR YOUR ORDER" of the successful purchase


