Feature: Movita BDD Deneme
    @TestCaseKey=MVT-T59
    Scenario: Movita BDD Deneme
        
        Given I am on the login page
        When I enter my valid credentials with username "example_user" and password "password123"
        And I click on the login button
        Then I should be redirected to the home page
        And I should see a welcome message with my name "Example User"