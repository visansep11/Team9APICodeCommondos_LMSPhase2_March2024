
Feature: User Role Program Batch Map Controller

 
  Scenario: Check if admin is able to retreive all Admins with assigned program batches
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches 
    When Admin sends HTTPS Request
    Then Admin2 received 200 OK

  Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches without authorization
    When Admin sends HTTPS Request without authorization
    Then admin1 received status 401 with Unauthorized message
    
  Scenario: Check if admin is able to retreive all Admins with assigned program batches with invalid2 endpoint2
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches
    When Admin sends HTTPS Request with invalid2 endpoint2
    Then admin1 received status 404

	Scenario Outline: Check if admin is able to retreive assigned program batches for valid AdminId
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by AdminId
    When Admin sends HTTPS Request to get assigned program by adminId "<adminId>" endpoint
    Then Admin received "<status>" in response body
    Examples: 
      | adminId|status|
      | U1489		|200	|
      |U@1489		 |404		|
      |143			 |404		|
    	|null				|404	|
    
  Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches with no authorization
    When Admin sends HTTPS Request without authorization
    Then admin1 received status 401 with Unauthorized message
    
   
  Scenario Outline: Check if admin is able to retreive assigned program batches for valid adminId with invalid2 endpoint2
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by AdminId
    When Admin sends HTTPS Request to get assigned program by adminId "<adminId>" with invalid2 endpoint2
    Then admin1 received status 404
    Examples: 
      | adminId|
      | U1489		|
      
    Scenario Outline: Check if admin is able to delete the program batch for valid Admin and No Authorization
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by valid AdminId and no auth
    When Admin sends HTTPS Request to delete endpoint  by "<adminId>"
    Then admin1 received status 401 with Unauthorized message
   	Examples: 
      | adminId| 
      #| U1596	|
 			
   
 Scenario Outline: Check if admin is able to delete the program batch for a Admin
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId
    When Admin sends HTTPS Request to delete endpoint  by "<adminId>"
    Then Admin received "<status>" in response body
    Examples: 
      | adminId| status|
      | U1596	| 200|
 			| U@157 | 404|

    