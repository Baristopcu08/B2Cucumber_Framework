Feature: login functionality

  Scenario: login with true credentials
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible

    When  user fill the login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |
    And   user clicks Login button
    Then  login should be successfull
    And   Account page should be visible


  Scenario Outline: login with false credentials


    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible
    When  user fill the login form with the following datas

      | username | <Username> |
      | password | <Password> |

    And   user clicks Login button
    Then  Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed

    Examples:
      | Username            | Password  |
      | xyzabc123@gmail.com | xyzabc123 |
      | xyzabc123@gmail.com | 12345     |


  Scenario: login with emty credentials

    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible
    When  Don't enter anything into the E-Mail Address field
    And   Don't enter anything into the Password field
    And   user clicks Login button
    Then  Warning message with the text "Warning: No match for E-Mail Address and/or Password." should be displayed


   Scenario: login with true credentials with Press Tab keyboard

    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible
    When user fill the E-Mail Address form with the following datas with  Press Tab keyboard
      | username | deneme@deneme.com |
    And user fill the Password form with the following datas with  Press Tab keyboard
      | password | deneme            |

  Scenario: Forgotten Password

    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    And   user click on Forgotten Password link
    Then  user should be taken to Login page and Forgotten Password link should be displayed in the page
    And   user should be taken to Forgotten Password page

  Scenario: login with true credentials Click on Browser back button
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible
    When  user fill the login form with the following datas
      | username | deneme@deneme.com |
      | password | deneme            |
    And  user clicks Login button
    And Click on Browser back button
    Then User should not logged out