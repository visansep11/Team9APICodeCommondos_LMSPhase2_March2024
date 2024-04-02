package com.LMSAPI.StepDef;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;

import com.LMSAPI.Authentication.BearerAuth;
import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.PayLoad.ProgramBatchPayload;
import com.LMSAPI.PayLoad.ProgramControllerPayload;
import com.LMSAPI.Runner.LMSAPIRunner;
import com.LMSAPI.Utilities.PathReader;
import com.LMSAPI.Utilities.TestValidationPage;
import com.ReqSpecBuilder.ReqestBuilder;
import com.jayway.jsonpath.JsonPath;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.LMSAPI.StepDef.ProgramController;
public class ProgramBatchController {


	Response response;
	RequestSpecification requestSpecification;
	String valid_response;
	private static final String Bearer_Token = null;
	RequestSpecBuilder requestSpec;
	io.restassured.path.json.JsonPath jsonPath;
	public List<Response> responses = new ArrayList<>();
	public static String requestBody;
	public static List<Map<String, String>> excelinput;
	public static PathReader path = new PathReader();
	public static String batchId;
	
	@Given("Admin creates programBatch request")
	public void admin_creates_program_batch_request() {
		requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
	}
//@01PostRequest_ProgramBatchController
	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() throws InvalidFormatException, IOException{
		ProgramBatchPayload.PostCreateProgramBatchRequest().stream().forEach(item->{
            this.response = requestSpecification
					 .when().log().all()
					 .spec(ReqestBuilder.PostCreateProgramBatch()).body(item)
				.post();
            responses.add(response);
            System.out.println("response:"+response.asPrettyString());
      	});
      	System.out.println("The size of my response list is:"+responses.size());
    	
	}
	@Then("Admin receives {int} Created programbatch Status with response body.")
	public void admin_receives_created_programbatch_status_with_response_body(Integer int1) {
	
		responses.stream().forEach(item->{
			if(item.getStatusCode()==201) {
				System.out.println("Programbatch Created");
				valid_response = response.then().log().all()
						.assertThat().statusCode(201).extract().response().asString();
				jsonPath = response.jsonPath();
				batchId = jsonPath.getString("batchId");
			}
			
			else if (item.getStatusCode()==400) {
				valid_response = response.then().log().all().assertThat().statusCode(400).extract().response().asString();
				System.out.println("Negative Scenario");
			}
			
			else if (item.getStatusCode()==401) {
				valid_response = response.then().log().all().assertThat().statusCode(401).extract().response().asString();
				System.out.println("Negative Scenario");
			}
		});
	}
	
//@01PostRequest_ProgramBatchController_InvalidEndpoint  
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
	    
		try{
			 
			this.response = requestSpecification
						 .when().log().all()
						 .spec(ReqestBuilder.PostCreateProgramBatch_InvalidEndpoint())
						 .body(ProgramBatchPayload.PostCreateProgramBatchRequest_Invalid())
					.post();
			System.out.println("response is :" +response);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Then("Admin receives {int} not found  programbatch Status with message and boolean success details")
	public void admin_receives_not_found_programbatch_status_with_message_and_boolean_success_details(Integer int1) {
		valid_response = response.then().log().all().assertThat().statusCode(404).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	
//@02GetRequest(All_Batches)_ProgramBatchController
	@When("Admin sends HTTPS GET Request with endpoint")
	public void admin_sends_https_get_request_with_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_All_Programsbatches);
	}
	@Then("Admin receives {int} Ok Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		TestValidationPage.GetbatchValidation200(response);
	}
	
//@02GetRequest(All_Batches)_ProgramBatchController_with_search_string
	
	@Given("Admin creates programBatch request with search string")
	public void admin_creates_program_batch_request_with_search_string() {
		requestSpecification= RestAssured.given().queryParam("batchName", "test").header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	
//@02GetRequest(All_Batches)_ProgramBatchController_InvalidEndpoint
	@When("Admin sends HTTPS GET Request with invalid endpoint")
	public void admin_sends_https_get_request_with_invalid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Invalid_Get_All_Programsbatches);
	}

	@Then("Admin receives {int} status with error message Not Found")
	public void admin_receives_status_with_error_message_not_found(Integer int1) {
		TestValidationPage.GetValidation(response);

	}
//@3GETREQUEST{byBatchID}	
	@Given("Admin creates programBatch request by ID Request for the LMS API with valid {string}")
	public void admin_creates_program_batch_request_by_id_request_for_the_lms_api_with_valid(String batchID) {
		requestSpecification= RestAssured.given().pathParam("batchId", batchID).header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS GET Request by batch id with endpoint")
	public void admin_sends_https_get_request_by_batch_id_with_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_Programbatch_By_ID);
	}

	@Then("Admin receives {string} program Status with response body programbatch")
	public void admin_receives_program_status_with_response_body_programbatch(String string) {
		response.prettyPrint();
		valid_response = response.then().log().all().assertThat().extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	    if(statuscode==200) { 
	    	assertEquals(200, statuscode);
	    }else {
	    	assertEquals(400, statuscode);
	    }
	}
//@3GETREQUEST{byBatchID}_invalid end point
	@When("Admin sends HTTPS GET Request by batch id with invalid endpoint")
	public void admin_sends_https_get_request_by_batch_id_with_invalid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Invalid_Get_Programbatch_By_ID);
	}
//@4GETREQUEST{byBatchName}
	@Given("Admin creates GET Request with valid {string}")
	public void admin_creates_get_request_with_valid(String batchName) {
		requestSpecification= RestAssured.given().pathParam("batchName", batchName).header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS Request with endpoint by batchname with valid endpoint")
	public void admin_sends_https_request_with_endpoint_by_batchname_with_valid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_Programbatch_By_BatchName);
	}
//@4GETREQUEST{byinvalidendpointBatchName}
	@When("Admin sends HTTPS Request with endpoint by batchname with invalid endpoint")
	public void admin_sends_https_request_with_endpoint_by_batchname_with_invalid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Invalid_Get_Programbatch_By_BatchName); 
	}
//@5GETREQUEST{byprogramid}	
	@Given("Admin creates GET Request with valid  programid {string}")
	public void admin_creates_get_request_with_valid_programid(String programId) {
		requestSpecification= RestAssured.given().pathParam("programId", programId).header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS GET Request by program id with endpoint")
	public void admin_sends_https_get_request_by_program_id_with_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_ProgramID_By_ID);
	}

//@5GETREQUEST{byprogramid}_invalid end point
	
	@When("Admin sends HTTPS GET Request  by program id with  invalid endpoint")
	public void admin_sends_https_get_request_by_program_id_with_invalid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Invalid_Get_ProgramID_By_ID);
	}

//@post with noauth

@Given("Admin creates programBatch request with no auth")
public void admin_creates_program_batch_request_with_no_auth() {
	requestSpecification= RestAssured.given();
}


//put_noauth

		@Given("Admin creates PUT Request with valid BatchId and Data no auth {string}")
		public void admin_creates_put_request_with_valid_batch_id_and_data_no_auth(String batchId) {
			requestSpecification = RestAssured.given().pathParam("batchId", 8600);
		}

		@When("Admin sends HTTPS put batch Request  with endpoint")
		public void admin_sends_https_put_batch_request_with_endpoint() {
			this.response = requestSpecification
					.when().log().all()
					.spec(ReqestBuilder.PutCreateProgramBatchID()).body(ReqestBuilder.PutCreateProgramBatchRequest())
					.put();
		}
//put with auth
		
		@Given("Admin creates PUT Request with valid BatchId and Data {string}")
		public void admin_creates_put_request_with_valid_batch_id_and_data(String string) {
			requestSpecification = RestAssured.given().pathParam("batchId", 8600).header("Authorization",BearerAuth.BearerAuthAPITest());
		}
//put woth auth_invalidendpoint

@When("Admin sends HTTPS put batch Request  with invalid endpoint")
public void admin_sends_https_put_batch_request_with_invalid_endpoint() {
	this.response = requestSpecification
			.when().log().all()
			.spec(ReqestBuilder.InvalidPutCreateProgramBatchID()).body(ReqestBuilder.PutCreateProgramBatchRequest())
			.put();
}
}


