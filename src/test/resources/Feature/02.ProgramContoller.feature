@ProgramController 
Feature: Program Controller

@NoAuth-PostProgramController
	Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates Post Program Controller Request with No Auth 
    When Admin sends HTTPS Program Controller Request with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details
    
 @01PostRequest_Program
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS post program Request and  request Body with endpoint
    Then Admin receives 201 Created program Status with response body.
    
  @01PostRequest_Program_InvalidEndpoint
  Scenario: Check if Admin able to create a program with invalid endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS post program Request and  request Body with invalid endpoint
    Then Admin receives 404 not found  program Status with message and boolean success details
    
    @01PostRequest_Program_2_InvalidBaseURI
  Scenario: Check if Admin able to create a program with invalid BaseURI and valid endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS post program Request and  request Body with invalid BaseURI and valid endpoint
    Then Admin receives 404 not found  program Status with message and boolean success details
    
    @01PostRequest_Program_InvalidMethod
  Scenario: Check if Admin able to create a program with invalid method
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS post program Request and request Body with endpoint along with invalid method
    Then Admin receives 405 Method Not Allowed for program controller
        
  @NoAuth-GetAllPgmsProgramController
	Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates get all programs Request with No Auth 
    When Admin sends HTTPS get all programs Request with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details
    
  @02GetRequest_AllPrograms
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS get program Request with endpoint
    Then Admin receives 200 OK get program Status with response body.   
    
  @02GetRequest_AllPrograms_InvalidEndpoint
  Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request with invalid endpoint
    Then Admin receives 404 not found  program Status with message and boolean success details   
    
	@02GetRequest_AllPrograms_InvalidBaseURI
  Scenario: Check if Admin able to retrieve all programs with invalid BaseURI and valid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program get Request with invalid BaseURI and valid endpoint
    Then Admin receives 404 not found  program Status with message and boolean success details 
    
    @02GetRequest_AllPrograms_InvalidMethod
  Scenario: Check if Admin able to retrieve all programs with invalid Method
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod
    Then Admin receives 405 Method Not Allowed for program controller 
    
     @NoAuth-GetByProgramIDProgramController
	Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin creates get all programs Request with No Auth 
    When Admin sends HTTPS get by "<programID>" Request with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details
   
   @03GetRequest_ValidProgramID
  Scenario Outline: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates GET program by ID Request for the LMS API with valid "<programID>"
    When Admin sends HTTPS get by program ID Request with endpoint
    Then Admin receives "<status>" program Status with response body. 
        Examples: 
      | programID		|status|
      | 16595				|200	|
      |ffg16jhg83g9	|400	|
      |asdffdf				|400	|
      |#@$%^^&**			|401	|
      |!@#$%1235556	|401	|
      |							|404	|
      |125						|404	|
      
   @03GetRequest_ValidProgramID_Bug
  Scenario Outline: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates GET program by ID Request for the LMSAPI with valid "<programID>"
    When Admin sends HTTPS get by programID Request with endpoint
    Then Admin receives "<status>" program get Status with response body.
    Examples: 
      | programID|status|
      |1 6 5 9 5			|400	|		
      				
   @03GetRequest_ProgramID_InvalidBaseURI
  Scenario: Check if Admin able to retrieve a program with invalid baseURI and valid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request with invalid baseURI and valid endpoint
    Then Admin receives 404 Not Found get program Status with message and boolean success details
    
     @03GetRequest_ProgramID_InvalidEndPoint
  Scenario: Check if Admin able to retrieve a program with valid BaseURL and invalid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request with valid BaseURI and invalid endpoint
    Then Admin receives 405 Method Not Allowed for program controller
    
    @03GetRequest_ValidProgramID_InvalidMethod
  Scenario: Check if Admin able to retrieve all programs with valid programID along with invalid Method
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod and valid programID
    Then Admin receives 405 Method Not Allowed for program controller 
    
    @04GetAllPrograms_WithAdmins
  Scenario: Check if Admin able to retrieve all programs with admin details along with valid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS program Request with endpoint
    Then Admin receives 200 OK get program Status with response body. 
    
    @04GetAllPrograms_WithAdmins_InvalidBaseURI
  Scenario: Check if Admin able to retrieve all programs with admins along with invalid baseURI and valid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS get all program Request with invalid baseURI and valid endpoint
    Then Admin receives 404 Not Found get program Status with message and boolean success details
    
     @04GetAllPrograms_WithAdmins_InvalidEndPoint
  Scenario: Check if Admin able to retrieve all programs with admins along with valid BaseURL and invalid Endpoint
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS get all program with users Request with valid BaseURI and invalid endpoint
    Then Admin receives 404 Not Found get program Status with message and boolean success details 
    
    
    @04GetAllPrograms_WithAdmins_InvalidMethod
  Scenario: Check if Admin able to retrieve all programs with admin along with invalid Method
    Given Admin creates GET program Request for the LMS API
    When Admin sends HTTPS get all programs with users program Request and request Body with endpoint along with invalidmethod 
    Then Admin receives 405 Method Not Allowed for program controller   
    
    @NoAuth-PutProgramIDProgramController                                                       
		Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin updates program details by "<programId>" Request with No Auth 
    When Admin sends HTTPS update Request by programID with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details                                                       
		
   @05PutRequest_updateProgrambyID_ValidID
  Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields "<programID>". 
    When Admin sends HTTPS program Request with valid endpoint
    Then Admin receives 200 OK Status with updated value in response body.                                           
       		
  #@05PutRequest_updateProgrambyID_InValidID
  #Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields "<programID>". 
    #When Admin sends HTTPS program update Request with invalid endpoint
    #Then Admin receives 404 Not Found get program Status with message and boolean success details     
    
 #@05PutRequest_updateProgrambyID_InvalidBaseURI
  #Scenario: Check if Admin able to update a program with invalid baseURI
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
   #
   #@05PutRequest_updateProgrambyID_InvalidEndPoint
  #Scenario: Check if Admin able to update a program with valid baseURI and invalid endpoint
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid baseURI and invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
                                            
  #@05PutRequest_updateProgrambyID_InvalidMethod
  #Scenario: Check if Admin able to update programs with invalid Method and valid programID
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method 
    #Then Admin receives 405 Method Not Allowed for program controller    
    #
    #@NoAuth-PutProgramNameProgramController                                                       
#		Scenario: Check if admin is able to update the Admin login status by Admin ID
    #Given Admin updates program details by "<programName>" Request with NoAuth 
    #When Admin sends HTTPS update Request by programName with endpoint valid data for login status in request body 
    #Then Admin receives 401 Bad Request Status for program controller with message and boolean success details
    #
  #@06PutRequest_updateProgramby_ProgramName
  #Scenario: Check if Admin able to update a program with  Valid program Name and request body
    #Given Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 200 OK Status with updated value in response body. 
                                                                                         #
#@06PutRequest_updateProgramby_InvalidProgramName
  #Scenario: Check if Admin able to update a program with  invalid program Name and request body
    #Given Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details.  
    #
 #@06PutRequest_updateProgrambyProgramName_InvalidBaseURI
  #Scenario: Check if Admin able to update a program with invalid baseURI
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
   #
   #@06PutRequest_updateProgrambyProgramName_InvalidEndPoint
  #Scenario: Check if Admin able to update a program with valid baseURI and invalid endpoint
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid baseURI and invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details  
    #
    #@05PutRequest_updateProgrambyProgramName_InvalidMethod
  #Scenario: Check if Admin able to update programs with invalid Method and valid programName
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program Name
    #Then Admin receives 405 Method Not Allowed for program controller  
      
  @NoAuth-DeleteProgramNameProgramController                                                       
		Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin deletes program details by "<programName>" Request with NoAuth 
    When Admin sends HTTPS delete Request by programName with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details 
  
  @07DeleteRequest_ProgramName
  Scenario Outline: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE program Request for the LMS API endpoint with valid "<programName>" 
    When Admin sends HTTPS delete program name Request with endpoint
    Then Admin receives "<status>" delete program Status with response body.
    Examples: 
      | programName															|status|
      |abcd																			|404	|
      |abcd233ass																|404	|
      |asdfdfdsfd																|404	|
      |#@$%^^&**																	|404	|
      |																					|	404	|
      |!@#$%1235556															|404	|
      |team9RestASSuredHackathonMarch2056_SDET3	|200|
       
   @07DeleteRequest_ValidProgramID_Bug
  Scenario: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates delete program by ID Request for the LMSAPI with valid "<programId>"
    When Admin sends HTTPS program delete by programID Request with endpoint
    Then Admin receives "<status>" program delete Status with response body.
    	
    @07DeleteRequest_ProgramName_InvalidBaseURI
  Scenario: Check if Admin able to delete a program with invalid BaseURI and valid endpoint and valid programName
    Given Admin creates DELETE program Request for the LMS API endpoint
    When Admin sends HTTPS delete program name Request with invalid base url and valid endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
     @07DeleteRequest_ProgramName_InvalidEndpoint
  Scenario: Check if Admin able to delete a program with valid BaseURI, Invalid endpoint and valid programName
    Given Admin creates DELETE program Request for the LMS API endpoint  
    When Admin sends HTTPS program delete Request with endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
    @07DeleteRequest_ProgramName_InvalidMethod
  Scenario: Check if Admin able to delete programs with invalid Method and valid programName
    Given Admin creates DELETE program Request for the LMS API endpoint
    When Admin sends HTTPS program delete Request and request Body with endpoint along with invalid method and valid Program Name
    Then Admin receives 405 Method Not Allowed for program controller  
    
    @NoAuth-DeleteProgramIDProgramController                                                       
		Scenario: Check if admin is able to update the Admin login status by Admin ID
    Given Admin deletes program details by "<programId>" Request with No Auth 
    When Admin sends HTTPS delete Request by programID with endpoint valid data for login status in request body 
    Then Admin receives 401 Bad Request Status for program controller with message and boolean success details 
  
  @08DeleteRequest_ProgramID
  Scenario Outline: Check if Admin able to delete a program with valid program ID 
    Given Admin creates DELETE programRequest by program ID for the LMS API endpoint "<programId>" 
    When Admin sends HTTPS Delete program Request by ID with endpoint 
    Then Admin receives "<Status>" Ok status with message
      Examples: 
      | programId																|status|
      |abcd																			|404	|
      |abcd233ass																|404	|
      |asdfdfdsfd																|404	|
      |#@$%^^&**																|404	|
      |																					|	404	|
      |!@#$%1235556															|404	|
      |16595																			|200|
			
 @08DeleteRequest_ProgramID_InvalidBaseURI
  Scenario: Check if Admin able to delete a program with invalid BaseURI and valid endpoint and valid programID
    Given Admin creates DELETE program Request for the LMS API endpoint 
    When Admin sends HTTPS Delete program Request with Invalid BaseURI endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
     @08DeleteRequest_ProgramID_InvalidEndpoint
  Scenario: Check if Admin able to delete a program with valid BaseURI, Invalid endpoint and valid programID
    Given Admin creates DELETE program Request for the LMS API endpoint 
    When Admin sends HTTPS delete program Request with valid baseurl and invalid endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
     @08DeleteRequest_ProgramID_InvalidMethod
  Scenario: Check if Admin able to delete programs with invalid Method and valid programID
    Given Admin creates DELETE program Request for the LMS API endpoint
    When Admin sends HTTPS program delete Request and request Body with endpoint along with invalid method and valid Program ID
    Then Admin receives 405 Method Not Allowed for program controller 
  
    
    

  