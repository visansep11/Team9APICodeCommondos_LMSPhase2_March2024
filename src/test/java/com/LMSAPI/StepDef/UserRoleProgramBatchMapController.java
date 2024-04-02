package com.LMSAPI.StepDef;


import static org.testng.Assert.assertEquals;

import com.LMSAPI.Authentication.BearerAuth;
import com.LMSAPI.Endpoints.LMSAPI_EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRoleProgramBatchMapController {
	
	
	RequestSpecification requestSpecification;
    Response response;
    
@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches")
public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches() {
    requestSpecification = RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
}

@When("Admin sends HTTPS Request")
public void admin_sends_https_request() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_all_program_users);
}

@Then("Admin2 received {int} OK")
public void admin2_received_ok(Integer int1) {
	response.prettyPrint();
	response.then().log().all().assertThat().statusCode(200).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches without authorization")
public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_without_authorization() {
	requestSpecification = RestAssured.given();
}


@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by AdminId")
public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_admin_id() {
    requestSpecification = RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());

}



@When("Admin sends HTTPS Request to get assigned program by adminId {string} endpoint")
public void admin_sends_https_request_to_get_assigned_program_by_admin_id_endpoint(String adminId) {
	this.response = requestSpecification.pathParam("userId", adminId).when().log().all().get(LMSAPI_EndPoints.Get_all_program_user_by_ID);

}

@Then("Admin received {string} in response body")
public void admin_received_in_response_body(String string) {
	response.prettyPrint();
	response.then().log().all().assertThat().extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
    if(statuscode==200) { 
    	assertEquals(200, statuscode);
    }else {
    	assertEquals(404, statuscode);
    }
}



@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches with no authorization")
public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_with_no_authorization() {
    requestSpecification = RestAssured.given();
    System.out.println("Sending request without authorization ");
}

@When("Admin sends HTTPS Request without authorization")
public void admin_sends_https_request_without_authorization() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_all_program_users);

}

@Then("admin1 received status {int} with Unauthorized message")
public void admin_received_status_with_unauthorized_message(Integer int1) {
	response.prettyPrint();
	response.then().log().all().assertThat().statusCode(401).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@When("Admin sends HTTPS Request with invalid2 endpoint2")
public void admin_sends_https_request_with_invalid_endpoint() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Invalid_Get_all_program_users);
}

@Then("admin1 received status {int}")
public void admin_receives_status(Integer int1) {
	response.prettyPrint();
	response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by invalid AdminID")
public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_invalid_admin_id() {
    requestSpecification = RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());

}

//@When("Admin sends HTTPS Request with invalid adminId {string}")
//public void admin_sends_https_request_with_invalid_admin_id(String userId) {
//	this.response = requestSpecification.pathParam("userId", "null").when().log().all().get(LMSAPI_EndPoints.Get_all_program_user_by_ID);
//
//}

@Then("Admin receives {int}")
public void admin_receives(Integer int1) {
	response.prettyPrint();
	response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@When("Admin sends HTTPS Request to get assigned program by adminId {string} with invalid2 endpoint2")
public void admin_sends_https_request_to_get_assigned_program_by_admin_id_with_invalid2_endpoint2(String adminId) {
	this.response = requestSpecification.pathParam("userId", adminId).when().log().all().get(LMSAPI_EndPoints.Invalid_Get_all_program_user_by_ID);

}

@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by valid AdminId and no auth")
public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_valid_admin_id_and_no_auth() {
	 requestSpecification = RestAssured.given();
}


@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by AdminId")
public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_admin_id() {
	 requestSpecification = RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
}

@When("Admin sends HTTPS Request to delete endpoint  by {string}")
public void admin_sends_https_request_to_delete_endpoint_by(String adminId) {
	this.response = requestSpecification.pathParam("userId", adminId).when().log().all().delete(LMSAPI_EndPoints.Delete_all_programs_by_ID);
 
}


}
