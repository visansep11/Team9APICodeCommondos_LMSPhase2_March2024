@tag
Feature: User Controller

    @PostUserAllFields
    Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with 
    mandatory fields and additional fields 
    Given Admin creates POST request 
    When Admin sends HTTPS Request with endpoint mandatory fields and additional fields
    Then Admin receives 201 Created Status with response body. 
    
    @PostUserexistingValuesForUniqueFields
    Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields
    Given Admin creates POST request 
    When Admin sends HTTPS Request with endpoint and existingValuesForUniqueFields
    Then Admin receives 400 Bad Request Status with error message.   
    
    @PostUserInvalidValues 
    Scenario: Check if admin is able to create a Admin with valid endpoint and invalid values in request body
    Given Admin creates POST request 
    When Admin sends HTTPS Request with endpoint and invalid values
    Then Admin receives 400 Bad Request Status with error message.    
   
    @PostUserMissingValues 
    Scenario: Check if Admin able to create a Admin missing mandatory fields in request body
    Given Admin creates POST request 
    When Admin sends HTTPS Request with endpoint and with missing mandatory fields in request body
    Then Admin receives 400 Bad Request Status with error message. 
    
    @PostUserNoAuth 
    Scenario: Check if Admin able to create a Admin with all mandatory fields in request body
    Given Admin creates POST request with No Auth
    When Admin sends HTTPS Request with endpoint mandatory fields and additional fields
    Then Admin receives status 401 with Unauthorized message
    
    @PutUpdateUserRoleIdwithValidUserId
    Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with endpoint, valid request body and valid UserId
    Then Admin receives 200 OK  Status with response body.
    
    @PutUpdateUserRoleIdwithInvalidUserId
    Scenario: Check if admin is able to update role id of a Admin by Invalid Admin id
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with endpoint, valid request body and Invalid UserId
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
    
    @PutUpdateUserInvalidRoleIdwithValidUserId
    Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with endpoint, invalid request body and valid UserId
    Then Admin receives 400 Bad Request Status with message and Boolean1 success details
   
    @PutUpdateUserExistingRoleIdwithValidUserId
    Scenario: Check if admin is able to update a Admin with Admin Role Id with already existing Admin role ID
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with endpoint, existing RoleId and valid UserId
    Then Admin receives 400 Bad Request Status with message and Boolean1 success details
    
    @PutUpdateUserRoleIdwithValidUserIdInvalidEndpoint  
    Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid1 endpoint1
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with invalid1 endpoint1, valid request body and valid UserId
    Then Admin receives status 404 with Not Found error message	Negative
   
    @PutUpdateUserRoleIdwithValidUserIdNoAuth
    Scenario: Check if admin is able to update role id of a Admin by valid Admin id
    Given Admin creates PUT Request with No Auth
    When Admin sends HTTPS Request with endpoint, valid request body and valid UserId
    Then Admin receives status 401 with Unauthorized message
    
    @UpdateUserRoleStatusvaliddata
    Scenario: Check if admin is able to update role status of a Admin with valid Admin id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpointand valid data in request body
    Then Admin receives 200 OK  Status with response body. 
    
    @UpdateUserRoleStatusinvaliddata 
    Scenario: Check if admin is able to update role status of a Admin with valid Admin id and invalid role status
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpointand invalid data in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details 
    
    @UpdateUserRoleStatusinvalidUserId 
    Scenario: Check if admin is able to update role status of a Admin with invalid Admin id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpoint valid data,Invalid userId in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details  
    
    @UpdateUserRoleStatusnonexisting/unassignedRoleID
    Scenario: Check if admin is able to update role status of a Admin for nonexisting/unassigned RoleID
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpoint valid data,valid userId,nonexisting/unassigned RoleID in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
    
    @UpdateUserRoleStatusInvalidEndpoint
    Scenario: Check if admin is able to update role status of a Admin with invalid1 endpoint1
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with invalid1 endpoint1 and valid data in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
    
    @UpdateUserRoleStatusNoAuth
    Scenario: Check if admin is able to update role status of a Admin with valid Admin id with No Authorization
    Given Admin creates PUT Request with No Auth   
    When Admin sends HTTPS Request with endpointand valid data in request body
    Then Admin receives 401 Bad Request Status with message and Boolean1 success details
    
    @UpdateAdminRoleProgramBatchstatusValidData
    Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpoint and valid data in request body
    Then Admin receives 200 Ok Status with response message  
    
    @UpdateAdminRoleProgramBatchstatusInValidData
    Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpoint and invalid data in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
    
    @UpdateAdminRoleProgramBatchstatusInValidUserId
    Scenario: Check if admin is able to assign Admin to with program/batch by invalid Admin Id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with endpoint,valid data in request body and Invalid UserId
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details 
    
    @UpdateAdminRoleProgramBatchstatusInvalidEndPoint
    Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
    Given Admin creates PUT Request   
    When Admin sends HTTPS Request with invalid1 endpoint1 and valid ProgramBatchstatus in request body
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
   
    @UpdateUserRoleStatusNoAuth
    Scenario: Check if admin is able to update role status of a Admin with valid Admin id with No Authorization
    Given Admin creates PUT Request with No Auth   
    When Admin sends HTTPS Request with endpoint and valid data in request body
    Then Admin receives 401 Bad Request Status with message and Boolean1 success details
    
    @UpdateAdminloginstatusValiddata
    Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request 
    When Admin sends HTTPS Request with endpoint valid data for login status in request body 
    Then Admin receives 200 OK
    
    @UpdateAdminloginstatusInValidData
    Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request  
    When Admin sends HTTPS Request with endpoint invalid data for login status in request body 
    Then Admin receives 400 Bad Request Status with message and Boolean1 success details
    
    @UpdateAdminloginstatusInValidUserId
    Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request  
    When Admin sends HTTPS Request with endpoint invalid UserId for login status in request body 
    Then Admin receives 404 Bad Request Status with message and Boolean1 success details
    
    @UpdateAdminloginstatusNoAuth
    Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates PUT Request with No Auth 
    When Admin sends HTTPS Request with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status with message and Boolean1 success details
    
    @UpdateUserInfoValiddata
    Scenario: Check if admin is able to update Admin details with Admin id and all fields
    Given Admin creates PUT Request  
    When Admin sends HTTPS request with endpoiint and valid data in request body (values only in all fields) 
    Then Admin receives 200 Ok status with message 
    
    @UpdateUserInfoInvaliddata
    Scenario: Check if admin is able to update Admin details with Admin id and all fields
    Given Admin creates PUT Request  
    When Admin sends HTTPS request with endpoiint and Invalid data in request body 
    Then Admin receives 400 Bad Request Status with error message. 
     
     @UpdateUserInfoInvalidUserId
    Scenario: Check if admin is able to update Admin details with Admin id and all fields
    Given Admin creates PUT Request  
    When Admin sends HTTPS request with endpoiint,valid data in request body and Invalid UserId
    Then Admin receives 404 Bad Request Status with error message.
   
    @UpdateUserInfoNoAuth
    Scenario: Check if admin is able to update Admin details with Admin id and all fields
    Given Admin creates PUT Request with No Auth
    When Admin sends HTTPS request with endpoiint and valid data in request body (values only in all fields) 
    Then Admin receives 401 Bad Request Status with message and Boolean1 success details 
    @GetAllRoles
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All Roles endpoint
    Then Admin receives 200 OK
    
    @GetAllRoles-InvalidEndpoint
    Scenario:  Check if admin is able to retreive all the available roles with invalid End point	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request with invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative		
   
    @GetAllRolesNoAuth
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request with GET All Roles endpoint
    Then Admin receives status 401 with Unauthorized message 
    
    @GetAllUsers
    Scenario:  Check if admin able to retrieve all Admin with valid endpoint
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All Users endpoint
    Then Admin receives 200 OK		
    
    @GetAllUsers-InvalidEndpoint
    Scenario:	 Check if admin is able to retreive all the users with invalid End point	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request GET All Users with invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative	
   
    @GetAllUsersNoAuth
    Scenario: Check if admin is able to retreive all the available users
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request with GET All Users endpoint
    Then Admin receives status 401 with Unauthorized message 
    
    @GetCountOfActiveandInactiveUsers
    Scenario:	 Check if admin is able to get count of active and inactive Admins	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request GET Count Of ActiveandInactive Users
    Then Admin receives 200 OK	
    
    @GetCountOfActiveandInactiveUsers-InvalidEndpoint
    Scenario:	 Check if admin is able to get count of active and inactive Admins with invalid1 endpoint1
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request GET Count Of ActiveandInactive Users with invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative	
    
    @GetCountOfActiveandInactiveUsersbyValidRoleId
    Scenario:	 Check if admin is able to get count of active and inactive Admins by roleId	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request with Valid roleId
    Then Admin receives 200 OK		
   
    @GetCountOfActiveandInactiveUsersbyInvalidRoleId
    Scenario:	Check if admin is able to get count of active and inactive Admins by invalid roleID 
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request with invalid rolrId	
    Then Admin receives status 404 with Not Found error message	Negative	
    
    @GetCountOfActiveandInactiveUsersNoAuth
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request with No Auth
    When  Admin sends HTTPS Request GET Count Of ActiveandInactive Users
    Then Admin receives status 401 with Unauthorized message 
    
    @GetUserbyValidUserID
    Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with valid endpoint and  valid UserId
    Then Admin receives 200 OK  Status with response body.  
    
    @GetUserbyInvalidUserID
    Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with valid endpoint and  Invalid UserId
    Then Admin receives status 404 with Not Found error message	Negative	
   
    @GetUserbyUserIDInavalidEndPoint
    Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request 
    When Admin sends HTTPS Request with invalid1 endpoint1 and valid UserId
    Then Admin receives status 404 with Not Found error message	Negative
    
    @GetUserbyUserIDNoAuth
    Scenario: Check if admin able to retrieve a Admin with valid Admin ID
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request with invalid1 endpoint1 and valid UserId
    Then Admin receives status 401 with Unauthorized message
                                                               
    @GetUserbyValidRoleID
    Scenario: Check if admin is able to retreive Admins by valid role ID	
    Given 	Admin creates GET Request  	
    When Admin sends HTTPS Request with endpoint and valid role ID
    Then Admin receives 200 OK
    
    @GetUserbyInvalidRoleID
    Scenario: Check if admin is able to retreive Admins by valid role ID	
    Given 	Admin creates GET Request  	
    When Admin sends HTTPS Request with endpoint and Invalid role ID
    Then Admin receives status 404 with Not Found error message
    
    @GetUserbyInvalidEndPoint
    Scenario: Check if admin is able to retreive Admins by valid role ID	
    Given Admin creates GET Request  	
    When Admin sends HTTPS Request with invalid1 endpoint1 and valid role ID
    Then Admin receives status 404 with Not Found error message
   
    @GetUserbyRoleIDNoAuth
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request with endpoint and valid role ID
    Then Admin receives status 401 with Unauthorized message  
    
    @GetAllUserswithRoles
    Scenario:  Check if admin able to retrieve all Admin with Roles 
    Given Admin creates GET Request
    When Admin sends HTTPS Request to GET All UserswithRoles with valid endpoint
    Then Admin receives 200 OK		
    
    @GetAllUserswithRoles-InvalidEndpoint
    Scenario:	 Check if admin is able to retreive all the available roles with invalid End point	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request to GET All UserswithRoles with invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative	
    
    @GetAllUserswithRoles-NoAuth
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request to GET All UserswithRoles with valid endpoint
    Then Admin receives status 401 with Unauthorized message
    
    @GetallActiveUser 
    Scenario:  Check if admin able to retrieve all Admin with valid endpoint
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All ActiveUsers endpoint
    Then Admin receives 200 OK		
    
    @GetAllActiveUsers-InvalidEndpoint
    Scenario:	 Check if admin is able to retreive all the available roles with invalid End point	
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request GET All ActiveUsers with invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative	
   
    @GetAllActiveUsersNoAuth
    Scenario: Check if admin is able to retreive all the available roles
    Given Admin creates GET Request with No Auth
    When  Admin sends HTTPS Request GET All ActiveUsers with invalid1 endpoint1
    Then Admin receives status 401 with Unauthorized message 
    
    @GetallUserswithFacets/Filters
    Scenario: Check if admin is able to retrieve all Admins with filters
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All Users withFacets/Filters endpoint
    Then Admin receives 200 OK		
    
    @GetAllActiveUsers-InvalidEndpoint
    Scenario: Check if admin is able to retrieve all Admins with filters with invalid1 endpoint1
    Given Admin creates GET Request	
    When  Admin sends HTTPS Request GET All Users withFacets/Filters invalid1 endpoint1	
    Then Admin receives status 404 with Not Found error message	Negative	
   
    @GetAllActiveUsersNoAuth
    Scenario: Check if admin is able to retrieve all Admins with filters with No Authorization
    Given Admin creates GET Request with No Auth
    When Admin sends HTTPS Request with GET All Users withFacets/Filters endpoint
    Then Admin receives status 401 with Unauthorized message 
 											
    @DeleteValidId
    Scenario: Check if Admin able to delete a Admin with valid Admin Id
    Given Admin creates DELETE Request to delete Admin details
    When Admin sends HTTPS request with endpoiint with Valid ID
    Then Admin receives 200 Ok status with message 
    @DeleteInvalidId
    Scenario: Check if Admin able to delete a Invalid Admin Id
    Given Admin creates DELETE Request to delete Admin details 
    When Admin sends HTTPS request with endpoiint with InValid ID
    Then Admin receives status 404 with Not Found error message  
    		

   