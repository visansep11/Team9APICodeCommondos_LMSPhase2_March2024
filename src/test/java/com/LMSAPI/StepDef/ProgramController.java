package com.LMSAPI.StepDef;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.LMSAPI.Authentication.BearerAuth;
import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Utilities.ConfigReaderAndWriter;
import com.LMSAPI.Utilities.FileNameConstants;
import com.LMSAPI.Utilities.PathReader;
import com.LMSAPI.Utilities.TestValidationPage;
import com.LMSAPI.Utilities.UserExcelUtility;
import com.ReqSpecBuilder.ReqestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.mongodb.diagnostics.logging.Logger;
import com.LMSAPI.PayLoad.*;
import com.LMSAPI.Pojo.ProgramPojo;
import com.LMSAPI.Runner.LMSAPIRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.LMSAPI.Utilities.LoggerLoad;

public class ProgramController {

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
	public static String ProgramId;

	//NoAuth-PostProgramController
	@Given("Admin creates Post Program Controller Request with No Auth")
	public void admin_creates_post_program_controller_request_with_no_auth() {
		requestSpecification= RestAssured.given();
		LoggerLoad.logInfo("***Admin sends No authorization to LMSAPI***");
	}

	@When("Admin sends HTTPS Program Controller Request with endpoint valid data for login status in request body")
	public void admin_sends_https_program_controller_request_with_endpoint_valid_data_for_login_status_in_request_body() throws IOException {
		this.response = requestSpecification
				.when().log().all()
				.spec(ReqestBuilder.PostCreateProgram()).body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
				.put();
	}

	@Then("Admin receives {int} Bad Request Status for program controller with message and boolean success details")
	public void admin_receives_bad_request_status_for_program_controller_with_message_and_boolean_success_details(Integer int1) {
		TestValidationPage.NoAuth(response);
		LoggerLoad.logDebug("No Auth :" +response);
	}

	//PostRequest_Program
	@Given("Admin creates GET program Request for the LMS API")
	public void admin_creates_get_program_request_for_the_lms_api() {
		requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}	

	@When("Admin sends HTTPS post program Request and  request Body with endpoint")
	public void admin_sends_https_post_program_request_and_request_body_with_endpoint() throws InvalidFormatException, IOException {

		ProgramControllerPayload.PostCreateProgramRequest().stream().forEach(item->{
			this.response = requestSpecification
					.when().log().all()
					.spec(ReqestBuilder.PostCreateProgram()).body(item)
					.post();
			responses.add(response);
			System.out.println("response:"+response.asPrettyString());
		});
		System.out.println("The size of my response list is:"+responses.size());
		LoggerLoad.logInfo("****New program is created ****");	

	}

	@Then("Admin receives {int} Created program Status with response body.")
	public void admin_receives_created_program_status_with_response_body(Integer int1) {

		responses.stream().forEach(item->{
			if(item.getStatusCode()==201) {

				valid_response = response.then().log().all()
						.assertThat().statusCode(201).and()
						.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema/postprogram.json")))
						.statusLine("HTTP/1.1 201 ")
						.extract().response().asString();
				jsonPath = response.jsonPath();
				ProgramId = jsonPath.getString("programId");
				System.out.println("CraetedUser:" +ProgramId);
				LoggerLoad.logInfo("Program created successfully with status code " + response.getStatusCode()) ;
				LoggerLoad.logInfo("Program Response body" +response.getBody().asString());
			}

			else if (item.getStatusCode()==400) {
				valid_response = response.then().log().all().assertThat().statusCode(400)
						.extract().response().asString();
				LoggerLoad.logError("Program Response body" +response.getStatusCode());

			}
		});

	}
	//PostRequest_Program_InvalidEndpoint
	@When("Admin sends HTTPS post program Request and  request Body with invalid endpoint")
	public void admin_sends_https_post_program_request_and_request_body_with_invalid_endpoint() throws IOException{
		try{

			this.response = requestSpecification
					.when().log().all()
					.spec(ReqestBuilder.PostCreateProgram_InvalidEndpoint())
					.body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
					.post();
			LoggerLoad.logInfo("****Post Program request with Invalid EndPoint ****");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("Admin receives {int} not found  program Status with message and boolean success details")
	public void admin_receives_not_found_program_status_with_message_and_boolean_success_details(Integer int1) {

		TestValidationPage.GetValidation(response);
		LoggerLoad.logDebug("Response :" +response);
	}

	//PostRequest_Program_2_InvalidBaseURI
	@When("Admin sends HTTPS post program Request and  request Body with invalid BaseURI and valid endpoint")
	public void admin_sends_https_post_program_request_and_request_body_with_invalid_base_uri_and_valid_endpoint() {
		//this.response = requestSpecification.when().log().all().post(LMSAPI_EndPoints.InvalidBaseURL_Create_Program);
		try{

			this.response = requestSpecification
					.when().log().all()
					.baseUri(LMSAPI_EndPoints.InvalidBaseURL_Create_Program)
					.body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
					.post();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//PostRequest_Program_InvalidMethod
	@When("Admin sends HTTPS post program Request and request Body with endpoint along with invalid method")
	public void admin_sends_https_post_program_request_and_request_body_with_endpoint_along_with_invalid_method() {
		try{

			this.response = requestSpecification
					.when().log().all()
					.spec(ReqestBuilder.PostCreateProgram())
					.body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
					.get();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Admin receives {int} Method Not Allowed for program controller")
	public void admin_receives_method_not_allowed_for_program_controller(Integer int1) {
		TestValidationPage.GetValidation_Method(response);
		LoggerLoad.logError("Response :" +response);   
	}
	
//NoAuth-GetAllPgmsProgramController
@Given("Admin creates get all programs Request with No Auth")
public void admin_creates_get_all_programs_request_with_no_auth() {
	requestSpecification= RestAssured.given();
	LoggerLoad.logInfo("***Admin sends No authorization to LMSAPI***");
}

@When("Admin sends HTTPS get all programs Request with endpoint valid data for login status in request body")
public void admin_sends_https_get_all_programs_request_with_endpoint_valid_data_for_login_status_in_request_body() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_All_Programs);
}

	//GetRequest_AllPrograms
	@When("Admin sends HTTPS get program Request with endpoint")
	public void admin_sends_https_get_program_request_with_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_All_Programs);

	}

	@Then("Admin receives {int} OK get program Status with response body.")
	public void admin_receives_ok_get_program_status_with_response_body(Integer int1) {

		TestValidationPage.GetValidation200_get(response);
		LoggerLoad.logInfo("Response :" +response);

	}
	//GetRequest_AllPrograms_InvalidEndpoint
	@When("Admin sends HTTPS program Request with invalid endpoint")
	public void admin_sends_https_program_request_with_invalid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.InvalidEndPoint_Get_All_Programs);

	}
	//GetRequest_AllPrograms_InvalidBaseURI
	@When("Admin sends HTTPS program get Request with invalid BaseURI and valid endpoint")
	public void admin_sends_https_program_get_request_with_invalid_base_uri_and_valid_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.InvalidBaseURL_Get_All_Programs);
	}
	//GetRequest_AllPrograms_InvalidMethod
	@When("Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod")
	public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalidmethod() {
		this.response = requestSpecification.when().log().all().post(LMSAPI_EndPoints.Get_All_Programs);

	}
	
	//NoAuth-GetByProgramIDProgramController
	@When("Admin sends HTTPS get by {string} Request with endpoint valid data for login status in request body")
	public void admin_sends_https_get_by_request_with_endpoint_valid_data_for_login_status_in_request_body(String programId) {
		this.response = requestSpecification.when().log().all().pathParam("programId",16213).get(LMSAPI_EndPoints.Get_Program_By_ID);
	}
	
	//GetRequest_ValidProgramID
	@Given("Admin creates GET program by ID Request for the LMS API with valid {string}")
	public void admin_creates_get_program_by_id_request_for_the_lms_api_with_valid(String programID) {
		requestSpecification= RestAssured.given().pathParam("programId", programID).header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS get by program ID Request with endpoint")
	public void admin_sends_https_get_by_program_id_request_with_endpoint() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_Program_By_ID);
	}


	@Then("Admin receives {string} program Status with response body.")
	public void admin_receives_program_status_with_response_body(String status) {

		TestValidationPage.GetValidationgetrequest(response);
		System.out.println("Response :" +response);
	}
	//GetRequest_ValidProgramID_Bug
	@Given("Admin creates GET program by ID Request for the LMSAPI with valid {string}")
	public void admin_creates_get_program_by_id_request_for_the_lmsapi_with_valid(String programID) {
		requestSpecification= RestAssured.given().pathParam("programId", programID).header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS get by programID Request with endpoint")
	public void admin_sends_https_get_by_program_id_request_with_endpoint1() {
		this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_Program_By_ID);
	}

	@Then("Admin receives {string} program get Status with response body.")
	public void admin_receives_program_get_status_with_response_body(String string) {
		TestValidationPage.GetValidationgetrequest_Bug(response);
		System.out.println("Response :" +response);
	}
	
	//GetRequest_ProgramID_InvalidBaseURI
	@When("Admin sends HTTPS program Request with invalid baseURI and valid endpoint")
	public void admin_sends_https_program_request_with_invalid_base_uri_and_valid_endpoint() throws IOException {

		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidBaseURL_Get_Program_By_ID);

	}
	@Then("Admin receives {int} Not Found get program Status with message and boolean success details")
	public void admin_receives_not_found_get_program_status_with_message_and_boolean_success_details(Integer int1) {
		TestValidationPage.GetValidation(response);
		System.out.println("Response :" +response);

	}
	//GetRequest_ProgramID_InvalidEndPoint
	@When("Admin sends HTTPS program Request with valid BaseURI and invalid endpoint")
	public void admin_sends_https_program_request_with_valid_base_uri_and_invalid_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidEndPoint_Get_Program_By_ID);

	}
	//GetRequest_ValidProgramID_InvalidMethod
	@When("Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod and valid programID")
	public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalidmethod_and_valid_program_id1() {
		this.response = requestSpecification
				.when().log().all()
				.post(LMSAPI_EndPoints.validBaseURL_Get_Program_By_ID);
	}
	//GetAllPrograms_WithAdmins
	@When("Admin sends HTTPS program Request with endpoint")
	public void admin_sends_https_program_request_with_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.Get_All_ProgramsWithUsers);
	}
	//GetAllPrograms_WithAdmins_InvalidBaseURI
	@When("Admin sends HTTPS get all program Request with invalid baseURI and valid endpoint")
	public void admin_sends_https_get_all_program_request_with_invalid_base_uri_and_valid_endpoint() {

		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidBaseURL_Get_All_Pgms_WithUsers);
	}
	//GetAllPrograms_WithAdmins_InvalidEndPoint
	@When("Admin sends HTTPS get all program with users Request with valid BaseURI and invalid endpoint")
	public void admin_sends_https_get_all_program_with_users_request_with_valid_base_uri_and_invalid_endpoint() {

		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidEndPoint_Get_All_ProgramsWithUsers);
	}
	//GetAllPrograms_WithAdmins_InvalidMethod
	@When("Admin sends HTTPS get all programs with users program Request and request Body with endpoint along with invalidmethod")
	public void admin_sends_https_get_all_programs_with_users_program_request_and_request_body_with_endpoint_along_with_invalidmethod() {
		this.response = requestSpecification
				.when().log().all()
				.post(LMSAPI_EndPoints.Get_All_ProgramsWithUsers);
	}
	
	//NoAuth-PutByProgramIdProgramController
	@Given("Admin updates program details by {string} Request with No Auth")
	public void admin_updates_program_details_by_request_with_no_auth(String string) {
		requestSpecification = RestAssured.given().pathParam("programId", 17485);
	}

	@When("Admin sends HTTPS update Request by programID with endpoint valid data for login status in request body")
	public void admin_sends_https_update_request_by_program_id_with_endpoint_valid_data_for_login_status_in_request_body() {
		this.response = requestSpecification
				.when().log().all()
				.spec(ReqestBuilder.PutCreateProgramID()).body(ReqestBuilder.PutCreateProgramRequest())
				.put();
	}
	
	
	@Given("Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields {string}.")
	public void admin_creates_put_program_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields(String programId) {
		requestSpecification= RestAssured.given()
				.pathParam("programId", 17036)
				.header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}
	@When("Admin sends HTTPS program Request with valid endpoint")
	public void admin_sends_https_program_request_with_valid_endpoint() throws InvalidFormatException, IOException {

		this.response = requestSpecification
				.when().log().all()
				.spec(ReqestBuilder.PutCreateProgramID()).body(ReqestBuilder.PutCreateProgramRequest())
				.put();
			responses.add(response);
			System.out.println("response:"+response.asPrettyString());
		
		System.out.println("The size of my response list is:"+responses.size());
		LoggerLoad.logInfo("****program is updated ****");

	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {


		responses.stream().forEach(item->{
			if(item.getStatusCode()==201) {

				valid_response = response.then().log().all()
						.assertThat().statusCode(201).and()
						//						.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema/postprogram.json")))
						.statusLine("HTTP/1.1 201 ")
						.extract().response().asString();
				jsonPath = response.jsonPath();
				ProgramId = jsonPath.getString("programId");
				System.out.println("UpdatedUser:" +ProgramId);
				LoggerLoad.logInfo("Program updated successfully with status code " + response.getStatusCode()) ;
				LoggerLoad.logInfo("Program update Response body" +response.getBody().asString());
			}

			else if (item.getStatusCode()==400) {
				valid_response = response.then().log().all().assertThat().statusCode(400)
						.extract().response().asString();
				LoggerLoad.logError("Program update Response body" +response.getStatusCode());

			}
		});
	}
	
//	@When("Admin sends HTTPS program update Request with invalid endpoint")
//	public void admin_sends_https_program_update_request_with_invalid_endpoint() {
//		this.response = requestSpecification
//				.when().log().all()
//				.spec(ReqestBuilder.PutCreateProgramID()).body(ReqestBuilder.PutCreateProgramRequest())
//				.put();
//	}

//	@When("Admin sends HTTPS program Request and request Body with endpoint along with invalid method")
//	public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalid_method() {
//
//
//	}
//
//	@When("Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program Name")
//	public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalid_method_and_valid_program_name() {
//
//
//	}
	//@NoNoAuth-PutProgramNameProgramController 
	@Given("Admin updates program details by {string} Request with NoAuth")
	public void admin_updates_program_details_by_request_with_no_auth1(String string) {
		requestSpecification = RestAssured.given().pathParam("programName", "ComputerScience");
	}

	@When("Admin sends HTTPS update Request by programName with endpoint valid data for login status in request body")
	public void admin_sends_https_update_request_by_program_name_with_endpoint_valid_data_for_login_status_in_request_body() {
		this.response = requestSpecification
				.when().log().all()
				.spec(ReqestBuilder.PutCreateProgramName()).body(ReqestBuilder.PutCreateProgramRequest())
				.put();
	}
	//@NoAuth-DeleteProgramNameProgramController
	@Given("Admin deletes program details by {string} Request with NoAuth")
	public void admin_deletes_program_details_by_request_with_no_auth1(String string) {
		requestSpecification = RestAssured.given().pathParam("programName", "ComputerScience");
		LoggerLoad.logInfo("***Admin sends No authorization to LMSAPI***");
	}

	@When("Admin sends HTTPS delete Request by programName with endpoint valid data for login status in request body")
	public void admin_sends_https_delete_request_by_program_name_with_endpoint_valid_data_for_login_status_in_request_body() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Delete_Program_By_ProgramName);
	}
	
	//DeleteRequest_ProgramName
	@Given("Admin creates DELETE program Request for the LMS API endpoint with valid {string}")
	public void admin_creates_delete_program_request_for_the_lms_api_endpoint_with_valid(String programName) {
		requestSpecification= RestAssured.given().pathParam("programName",programName).header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}

	@When("Admin sends HTTPS delete program name Request with endpoint")
	public void admin_sends_https_delete_program_name_request_with_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Delete_Program_By_ProgramName);
	}
	
	@Then("Admin receives {string} delete program Status with response body.")
	public void admin_receives_delete_program_status_with_response_body(String string) {
		TestValidationPage.GetValidationDelete(response);
		System.out.println("Response :" +response);
	}

	//DeleteRequest_ValidProgramID_Bug
	@Given("Admin creates delete program by ID Request for the LMSAPI with valid {string}")
	public void admin_creates_delete_program_by_id_request_for_the_lmsapi_with_valid(String string) {
		requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}

	@When("Admin sends HTTPS program delete by programID Request with endpoint")
	public void admin_sends_https_program_delete_by_program_id_request_with_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Delete_Program_By_ProgramID);
		LoggerLoad.logInfo("Expected status code 400 -BUG");
	}
	@Then("Admin receives {string} program delete Status with response body.")
	public void admin_receives_program_delete_status_with_response_body(String string) {
		TestValidationPage.GetValidationgetrequest_Bug(response);
		System.out.println("Response :" +response);
	}
	//Delete ProgramByName with InvalidBaseURL and Valid EndPoint
	@Given("Admin creates DELETE program Request for the LMS API endpoint")
	public void admin_creates_delete_program_request_for_the_lms_api_endpoint() {
		requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}

	@When("Admin sends HTTPS delete program name Request with invalid base url and valid endpoint")
	public void admin_sends_https_delete_program_name_request_with_invalid_base_url_and_valid_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Invalid_Delete_Program_By_ProgramName);
		LoggerLoad.logInfo("Admin Sends Delete Program request for Invalid BaseURl and Valid Endpoint");
	}

	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
		TestValidationPage.GetValidation(response);
		System.out.println("Response :" +response);
	}
	//DeleteRequest_ProgramName_InvalidEndpoint
	@When("Admin sends HTTPS program delete Request with endpoint")
	public void admin_sends_https_program_delete_request_with_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Invalid_Delete_Program_By_ProgramName );
		LoggerLoad.logInfo("Admin Sends Delete program request for InvalidEndpoint");
	}
	//DeleteRequest_ProgramName_InvalidMethod
	@When("Admin sends HTTPS program delete Request and request Body with endpoint along with invalid method and valid Program Name")
	public void admin_sends_https_program_delete_request_and_request_body_with_endpoint_along_with_invalid_method_and_valid_program_name() {
		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidMethod_Delete_Program_By_ProgramName);
		LoggerLoad.logInfo("Admin Sends Delete program request for InvalidMethod");
	}
	//@NoNoAuth-DeleteProgramIDProgramController 
		@Given("Admin deletes program details by {string} Request with No Auth")
		public void admin_deletes_program_details_by_request_with_no_auth(String programId) {
			requestSpecification = RestAssured.given().pathParam("programId",17485);
			LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
		}

		@When("Admin sends HTTPS delete Request by programID with endpoint valid data for login status in request body")
		public void admin_sends_https_delete_request_by_program_id_with_endpoint_valid_data_for_login_status_in_request_body() {
}
	//DeleteRequest_ProgramID
	@Given("Admin creates DELETE programRequest by program ID for the LMS API endpoint {string}")
	public void admin_creates_delete_program_request_by_program_id_for_the_lms_api_endpoint(String programId) {
		requestSpecification= RestAssured.given().pathParam("programId", programId).header("Authorization",BearerAuth.BearerAuthAPITest());
		LoggerLoad.logInfo("***Admin sends authorization to LMSAPI***");
	}
	@When("Admin sends HTTPS Delete program Request by ID with endpoint")
	public void admin_sends_https_delete_program_request_by_id_with_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.Delete_Program_By_ProgramID1);
		LoggerLoad.logInfo("Admin Sends Delete program request by ProgramID");
	}

	@Then("Admin receives {string} Ok status with message")
	public void admin_receives_ok_status_with_message(String string) {
		TestValidationPage.GetValidationDelete(response);
		System.out.println("Response :" +response);
	}
	//DeleteRequest_ProgramID_InvalidBaseURI
	@When("Admin sends HTTPS Delete program Request with Invalid BaseURI endpoint")
	public void admin_sends_https_delete_program_request_with_invalid_base_uri_endpoint() {

		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.InvalidBaseURL_Delete_Program_By_ProgramID );
		LoggerLoad.logInfo("Admin Sends Delete program request by ProgramID with InvalidBase URL");
	}
	//DeleteRequest_ProgramID_InvalidEndpoint
	@When("Admin sends HTTPS delete program Request with valid baseurl and invalid endpoint")
	public void admin_sends_https_delete_program_request_with_valid_baseurl_and_invalid_endpoint() {
		this.response = requestSpecification
				.when().log().all()
				.delete(LMSAPI_EndPoints.InvalidBaseURL_Delete_Program_By_ProgramID);
		LoggerLoad.logInfo("Admin Sends Delete program request by ProgramID with valid baseurl and invalid endpoint");
	}
	// InvalidMethod_Delete_Program_By_ProgramId
	@When("Admin sends HTTPS program delete Request and request Body with endpoint along with invalid method and valid Program ID")
	public void admin_sends_https_program_delete_request_and_request_body_with_endpoint_along_with_invalid_method_and_valid_program_id() {
		this.response = requestSpecification
				.when().log().all()
				.get(LMSAPI_EndPoints.InvalidMethod_Delete_Program_By_ProgramId);
		LoggerLoad.logInfo("Admin Sends Delete program request by ProgramID with valid invalid method ");

	}

}

