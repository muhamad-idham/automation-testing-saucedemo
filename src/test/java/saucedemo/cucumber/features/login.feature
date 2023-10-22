Feature: Login Page Saucedemo

  @Login @Positive
  Scenario: Success Login
    Given User see Saucedemo login page
    When User input username
    And User input password
    And User click login button
    Then User see the product page

  @Login @Negative
  Scenario: Failed Login using invalid username
    Given User see Saucedemo login page
    When User input invalid username
    And User input password
    And User click login button
    Then User get error message

  @Login @Negative
  Scenario: Failed Login using invalid password
    Given User see Saucedemo login page
    When User input username
    And User input invalid password
    And User click login button
    Then User get error message

  @Login @Negative
  Scenario: Locked out Login
    Given User see Saucedemo login page
    When User input locked out username
    And User input password
    And User click login button
    Then User get error locked out message

  @TDD
  Scenario Outline: User Login to Saucedemo
    Given User see Saucedemo login page
    When User input <username> as username
    And User input <password> as password
    And User click login button
    Then User verify <status> login result

    Examples:
      | username                  | password       | status   |
      | standard_user             | secret_sauce   | success  |
      | standard_user             | false_password | failed   |
      | locked_out_user           | secret_sauce   | locked   |
      | problem_user              | secret_sauce   | success  |
      | performance_glitch_user   | secret_sauce   | success  |
      | error_user                | secret_sauce   | success  |
      | visual_user               | secret_sauce   | success  |
