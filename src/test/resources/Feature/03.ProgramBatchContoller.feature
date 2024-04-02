@ProgramBatchController
 Feature: ProgramBatchController Module

@01PostRequest_ProgramBatchController
 Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
   Given Admin creates programBatch request
   When Admin sends HTTPS Request with endpoint 
   Then Admin receives 201 Created programbatch Status with response body.
 
 @01PostRequest_ProgramBatchController_noauth
 Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
   Given Admin creates programBatch request with no auth
   When Admin sends HTTPS Request with endpoint 
   Then Admin receives 401 Created programbatch Status with response body.
   
@01PostRequest_ProgramBatchController_InvalidEndpoint   
  Scenario: Check if admin able to create a batch with invalid endpoint
    Given Admin creates programBatch request
    When Admin sends HTTPS Request with invalid endpoint 
    Then Admin receives 404 not found  programbatch Status with message and boolean success details
    
@02GetRequest(All_Batches)_ProgramBatchController
	Scenario: Check if admin able to retrieve all batches
		Given Admin creates programBatch request
		When Admin sends HTTPS GET Request with endpoint
		Then Admin receives 200 Ok Status with response body

@02GetRequest(All_Batches)_ProgramBatchController_noauth
	Scenario: Check if admin able to retrieve all batches
		Given Admin creates programBatch request with no auth
		When Admin sends HTTPS GET Request with endpoint
		Then Admin receives 401 Created programbatch Status with response body.
 
 @02GetRequest(All_Batches)_ProgramBatchController_InvalidEndpoint
	Scenario: Check if admin able to retrieve all batches with invalid endpoint
		Given Admin creates programBatch request
		When Admin sends HTTPS GET Request with invalid endpoint
		Then Admin receives 404 status with error message Not Found
		
@02GetRequest(All_Batches)_ProgramBatchController_with_search_string
	Scenario: Check if admin able to retrieve all batches with search string
		Given Admin creates programBatch request with search string
		When Admin sends HTTPS GET Request with endpoint
		Then Admin receives 200 Ok Status with response body

@3GETREQUEST{byBatchID}
	Scenario Outline: Check if admin able to retrieve a batch with valid BATCH ID
		Given Admin creates programBatch request by ID Request for the LMS API with valid "<batchID>"
		When  Admin sends HTTPS GET Request by batch id with endpoint
		Then  Admin receives "<status>" program Status with response body programbatch
			Examples: 
      | batchID|status|
      |8600|200|
      |170361|400|
      |9803|400|
      |hello|404|
      |8b5rt7jhb0|405|
      	
@3GETREQUEST{byBatchID}
	Scenario Outline: Check if admin able to retrieve a batch with invalid endpoint
		Given Admin creates programBatch request by ID Request for the LMS API with valid "<batchID>"
		When  Admin sends HTTPS GET Request by batch id with invalid endpoint 
		Then  Admin receives 404 status with error message Not Found
		Examples: 
      | batchID|status|
      |8600|404|

@4GETREQUEST{byBatchName}
	Scenario Outline: Check if admin able to retrieve a batch with valid BATCH NAME
		Given Admin creates GET Request with valid "<batchName>"
		When Admin sends HTTPS Request with endpoint by batchname with valid endpoint
		Then Admin receives "<status>" program Status with response body programbatch
		Examples: 
      | batchName|status|
      |SDET1|200|
      |testteam1459|200|
      |testteamwert|400|
      

@4GETREQUEST{byinvalidendpointBatchName}
	Scenario Outline: Check if admin able to retrieve a batch with invalid endpoint
		Given Admin creates GET Request with valid "<batchName>"
		When Admin sends HTTPS Request with endpoint by batchname with invalid endpoint
		Then Admin receives 404 status with error message Not Found
		Examples: 
      | batchName|status|
      |SDET1|404|
      
@5GETREQUEST{byprogramid}
	Scenario Outline: Check if admin able to retrieve a batch with valid Program ID
		Given Admin creates GET Request with valid  programid "<programId>"
		When Admin sends HTTPS GET Request by program id with endpoint
		Then Admin receives "<status>" program Status with response body programbatch
		Examples: 
      | programId|status|
      |16595|200|
      |170361|400|
      


@5GETREQUEST{byprogramid}
	Scenario Outline: Check if admin able to retrieve a batch with invalid Program Id
		Given Admin creates GET Request with valid  programid "<ProgramId>"
		When Admin sends HTTPS GET Request  by program id with  invalid endpoint 
		Then Admin receives 404 status with error message Not Found
		Examples: 
		| ProgramId|status|
      |16595|404|
		
@6PUTREQUEST{UpdateBatch_bybatchID}_noauth
	Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
		Given Admin creates PUT Request with valid BatchId and Data no auth "<batchID>"
		When Admin sends HTTPS put batch Request  with endpoint
		Then Admin receives 401 Created programbatch Status with response body.


@6PUTREQUEST{UpdateBatch_bybatchID}
	Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
		Given Admin creates PUT Request with valid BatchId and Data "<batchID>"
		When Admin sends HTTPS put batch Request  with endpoint
		Then Admin receives 201 Created programbatch Status with response body.

@6PUTREQUEST{UpdateBatch_bybatchID}
	Scenario: Check if admin able to update a Batch with invalid enpoint
		Given Admin creates PUT Request with valid BatchId and Data "<batchID>"
		When Admin sends HTTPS put batch Request  with invalid endpoint
		Then Admin receives 404 status with error message Not Found
#		
#@7DELETEREQUEST(by_BatchID)
#	Scenario: Check if admin able to delete a Batch with valid Batch ID
#		Given Admin creates DELETE Request with valid BatchId
#		When Admin sends HTTPS delete Request  with endpoint
#		Then Admin receives "<status>" status with message
#
#@7DELETEREQUEST(by_BatchID)
#	Scenario: Check if admin able to delete a Batch with invalid Batch ID
#		Given Admin creates DELETE Request with valid BatchId
#		When Admin sends HTTPS delete Request  with invalid endpoint
#		Then Admin receives 404 not found
