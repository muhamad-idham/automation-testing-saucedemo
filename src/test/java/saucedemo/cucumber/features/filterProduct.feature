Feature: Filter Product Saucedemo

  @FilterProduct @Positive
  Scenario: Filter Product
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click filter button
    And User click filter sort by name z to a option
    Then User see the product with descending name
    And User click filter button
    And User click filter sort by name a to z option
    Then User see the product with ascending name

  @FilterProduct @Negative
  Scenario: Filter Sort Product by Price
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click filter button
    And User click filter sort by price low to high option
    Then User see the product with ascending price
    And User click filter button
    And User click filter sort by price high to low option
    Then User see the product with descending price

  @FilterProduct @Negative
  Scenario: Filter Sort Product by Price Using Problem User
    Given User see Saucedemo login page
    When User input problem username
    And User input password
    And User click login button
    And User click filter button
    And User click filter sort by price low to high option
    Then User see the product with ascending price
    And User click filter button
    And User click filter sort by price high to low option
    Then User see the product with descending price