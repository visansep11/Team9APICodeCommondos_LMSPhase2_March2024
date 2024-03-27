package com.LMSAPI.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Test {
	
	//private final String BASE_URL = "https://userapi-8877aadaae71.herokuapp.com/uap/users";
		Response response;
		//private Scenario scenario;
		RequestSpecification requestSpecification;
		ValidatableResponse valid_response;
		
	@Given("User creates GET Request for retrieving all userdetails")
	public void user_creates_get_request_for_retrieving_all_userdetails() {
		System.out.println("Getauth");
		
	}

	@When("User sends HTTPS Request to API")
	public void user_sends_https_request_to_api() {
		this.response = requestSpecification.when().get("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/users");
	}

	@Then("User receives {int} OK Status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
		valid_response = response.then().log().all()
				.assertThat().statusCode(200).contentType(ContentType.JSON);
	   
	}

}
