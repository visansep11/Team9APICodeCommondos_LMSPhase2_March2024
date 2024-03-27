package com.LMSAPI.Utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAPIHelper {
	public static RequestSpecification getBearer() {
		return RestAssured.given().auth().basic("numpyninja@gmail.com", "lmsHackathon@2024");
	}

}
