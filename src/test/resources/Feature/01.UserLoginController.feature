@tag
Feature: Post Request for User Login
Background: Admin sets No Auth

    @LoginWithValidCredential
    Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin1 received 200 created with auto generated token
    
    @LoginWithInValidCredential
    Scenario: Check if Admin able to generate token with invalid credential
    Given Admin creates request with invalid credentials
    When Admin calls Post Https method  with valid endpoint and invalid credentials
    Then Admin receives 401 Bad request
    
    @LoginWithInValidEndPoint
    Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with invalid endpoint and valid credentials
    Then Admin receives 401 Bad request
    
    @LogOutWithValidEndPoint
    Scenario: Check if Admin able to logout 
    Given Admin creates request with Auth
    When Admin calls Get Https method  with valid  Logout endpoint
    Then Admin1 received 200 ok  and response with "Logout successful"
   
    @LogOutWithValidEndPoint
    Scenario: Check if Admin able to logout  with invalid endpoint
    Given Admin creates request with Auth
    When Admin calls Get Https method  with invalid  Logout endpoint
    Then Admin receives status 404 
    
    @LogOutWithInvalidEndPoint
    Scenario: Check if Admin able to logout with no auth
    Given Admin creates GET Request with No Auth for LogOut
    When Admin calls Get Https method  with valid  Logout endpoint
    Then  Admin receives 401 Bad request