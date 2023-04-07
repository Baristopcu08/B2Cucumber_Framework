Feature: Validate adding a product to 'Wish List' page from the Product that is displayed in the 'Related Products' section of 'Product Display' page

  Scenario: WishList
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

    When Enter any existing Product name into the Search text box field

      | iMac |

    And Click on the button having search icon
    And Click on the Product displayed in the Search results
    And Click on Add to Wish List option on a product that is displayed in the Related Products section of displayed Product Display page
    Then Click on the wish list! link in the displayed success message