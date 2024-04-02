package com.LMSAPI.Utilities;

import static org.testng.Assert.assertEquals;

import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class TestValidationPage {

	public static void GetValidation200(Response response) {
		response.prettyPrint();
		response.then().log().all().assertThat().statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema/postprogram.json")))
		.extract().response().asString();
//		.extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
		public static void GetValidation200_get(Response response) {
		response.prettyPrint();
		response.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	
	public static void GetValidation(Response response) {
	response.prettyPrint();
	response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}
	public static void GetValidation_Method(Response response) {
		//response.prettyPrint();
		response.then().log().all().assertThat().statusCode(405);
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	
	public static void GetValidationDelete(Response response) {
		
		response.prettyPrint();
		response.then().log().all().extract().response().asString();
		int statuscode=response.getStatusCode();
		if(statuscode==200) {
			
			LoggerLoad.logInfo("Program Deleted successfully with status code " + response.getStatusCode()) ;
			 System.out.println("Statuscode:" +statuscode);
			 
		}else if(statuscode == 400 || statuscode == 401){
			LoggerLoad.logDebug("Program Delete response Status Code " + response.getStatusCode());	
			 System.out.println("Statuscode:" +statuscode);
			}
	}
		public static void GetValidationgetrequest(Response response) {
			
			response.prettyPrint();
			response.then().log().all().extract().response().asString();
			int statuscode=response.getStatusCode();
			if(statuscode==200) {
				
				LoggerLoad.logInfo("Get program details: " + response.getStatusCode()) ;
				 System.out.println("Get program details:" +statuscode);
				 
			}else if(statuscode == 400 || statuscode == 401){
				LoggerLoad.logDebug("Statuscode " + response.getStatusCode());	
				 System.out.println("Statuscode:" +statuscode);
				}
		}
			public static void GetValidationgetrequest_Bug(Response response) {
			response.prettyPrint();
			response.then().log().all().assertThat().extract().response().asString();
			int statuscode=response.getStatusCode();
		    System.out.println("Statuscode:" +statuscode);
		   assertEquals(200, 400);
			
}
			public static void NoAuth(Response response) {
				//response.prettyPrint();
				response.then().log().all().assertThat().statusCode(401);
				int statuscode=response.getStatusCode();
			    System.out.println("Statuscode:" +statuscode);
			}
			public static void GetbatchValidation200(Response response) {
				response.prettyPrint();
				response.then().log().all().assertThat().statusCode(200)
				//.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema/postprogram.json")))
				.extract().response().asString();
//				.extract().response().asString();
				int statuscode=response.getStatusCode();
			    System.out.println("Statuscode:" +statuscode);
				
			}
}

