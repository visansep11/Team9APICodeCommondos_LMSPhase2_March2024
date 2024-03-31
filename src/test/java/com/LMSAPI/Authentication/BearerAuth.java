package com.LMSAPI.Authentication;

//import com.LMSAPI.Utilities.RestAPIHelper;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import com.LMSAPI.Utilities.FileNameConstants;

//import com.testautomation.apitesting.listener.RestAssuredListener;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Utilities.ConfigReaderAndWriter;


public class BearerAuth {
//	ConfigReaderAndWriter configReaderObj;
//	static Properties prop; 
//	
//    public BearerAuth() {
//    	//pass object through constructor
//    	configReaderObj = new ConfigReaderAndWriter();
//    	 prop = configReaderObj.init_prop();
//    }
	 public static String BearerAuthAPITest() {
		
		String tokenAPIRequestBody = null;
		try {
			tokenAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.TOKEN_API_REQUEST_BODY),
					"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// token generation
		System.out.println("tokenAPIRequestBody :" + tokenAPIRequestBody );
					Response tokenAPIResponse = RestAssured
							.given()
							//.spec(RestAPIHelper.getBearer())
//								.filter(new RestAssuredListener())
								.contentType(ContentType.JSON)
								.body(tokenAPIRequestBody)
//								.baseUri("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/login")
								
							.baseUri(LMSAPI_EndPoints.User_Login)
							.when()
								.post()
							.then()
								.assertThat()
								.statusCode(200)
							.extract()
								.response();

					String token = JsonPath.read(tokenAPIResponse.body().asString(), "$.token");
					String authtoken = "Bearer "+token;
					System.out.println("Token Id : " + authtoken);
					return authtoken;
	  }
	  
	}


