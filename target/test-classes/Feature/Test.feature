@GetAll
Feature: Get all user details from the API
 
  @GetAllUsers
  Scenario: Get all users
    Given User creates GET Request for retrieving all userdetails
    When User sends HTTPS Request to API
    Then User receives 200 OK Status with response body