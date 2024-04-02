package com.LMSAPI.StepDef;

import java.util.Properties;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.PayLoad.UserLoginPayload;
import com.LMSAPI.Pojo.UserLoginPojo;
import com.LMSAPI.Runner.LMSAPIRunner;
import com.LMSAPI.Utilities.ConfigReaderAndWriter;
import com.ReqSpecBuilder.ReqestBuilder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginController {
	RequestSpecification request;
    Response response;
    RequestSpecBuilder requestSpec;
    String reqBody;
    JsonPath jsonPath;
    public static String Bearer_Token;

    ConfigReaderAndWriter configReaderObj;
	Properties prop; 
    
    public UserLoginController() {
    	//pass object through constructor
    	configReaderObj = new ConfigReaderAndWriter();
    	prop = configReaderObj.init_prop();
    }
    
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials()  {
		
			request= RestAssured.given();
				}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() throws Exception {
			
		response=request.when().log().all().spec(ReqestBuilder.PostUserSignIn()).body(UserLoginPayload.userLogin()).post();
				
	}

	@Then("Admin1 received {int} created with auto generated token")
	public void admin1_received_created_with_auto_generated_token(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	    jsonPath = response.jsonPath();
		 Bearer_Token = jsonPath.getString("token");
		
		
	}
	@Given("Admin creates request with invalid credentials")
	public void admin_creates_request_with_invalid_credentials() {
		request= RestAssured.given();
	}

@When("Admin calls Post Https method  with valid endpoint and invalid credentials")
public void admin_calls_post_https_method_with_valid_endpoint_and_invalid_credentials() throws Exception {
	response=request.when().log().all().spec(ReqestBuilder.PostUserSignIn()).body(UserLoginPayload.userLogin1()).post();
}

	@Then("Admin receives {int} Bad request")
	public void admin_receives_bad_request(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws Exception {
		response=request.when().log().all().spec(ReqestBuilder.InvalidPostUserSignIn()).body(UserLoginPayload.userLogin()).post();
	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	@When("Admin calls Post Https method  with invalid endpoint and valid credentials")
	public void admin_calls_post_https_method_with_invalid_endpoint_and_valid_credentials() throws Exception {
		response=request.when().log().all().spec(ReqestBuilder.InvalidPostUserSignIn()).body(UserLoginPayload.userLogin1()).post();
	}
	// LogOutWithValidEndPoint
	@Given("Admin creates request with Auth")
	public void admin_creates_request_with_auth() {
		request= RestAssured.given().header("Authorization","Bearer "+UserLoginController.Bearer_Token);
	}
	@When("Admin calls Get Https method  with valid  Logout endpoint")
	public void admin_calls_get_https_method_with_valid_logout_endpoint() {
		response=request.when().log().all().spec(ReqestBuilder.GetUserLogOut()).get();
	}
	@Then("Admin1 received {int} ok  and response with {string}")
	public void admin1_received_ok_and_response_with(Integer int1, String string) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//@LogOutWithInvalidEndPoint
	@Given("Admin creates GET Request with No Auth for LogOut")
	public void admin_creates_get_request_with_no_auth() {
		request= RestAssured.given();
	}
	@Then("Admin receives status {int}")
	public void admin_receives_status(Integer int1) {
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	@When("Admin calls Get Https method  with invalid  Logout endpoint")
	public void admin_calls_get_https_method_with_invalid_logout_endpoint() {
		response=request.when().log().all().spec(ReqestBuilder.InvalidGetLogOut()).get();
	}


}