package com.LMSAPI.Authentication;

import com.LMSAPI.Utilities.RestAPIHelper;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BearerAuth {
	@Before
	 public static void basicAuthAPITest() {
		  
		  RestAssured
		  		.given()
		  			.spec(RestAPIHelper.getBearer())
		  			.contentType(ContentType.JSON)
		  			.baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lmsswagger-ui.html#/")
		  		.when()
		  			.get()
		  		.then()
		  			.assertThat()
		  			.statusCode(200);
		  
	  }
	  
	}


