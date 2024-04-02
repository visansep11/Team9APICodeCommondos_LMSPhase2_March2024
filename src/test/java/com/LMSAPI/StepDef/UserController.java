package com.LMSAPI.StepDef;
import java.io.File;

import com.LMSAPI.PayLoad.CreateUserPayload;
import com.ReqSpecBuilder.ReqestBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserController {
	
	
	RequestSpecification request;
    Response response;
    RequestSpecBuilder requestSpec;
    String reqBody;
    JsonPath jsonPath;
    public static String User_id;
     
    //PostUserAllFields
	@Given("Admin creates POST request")
	public void admin_creates_post_request() {
		request= RestAssured.given().header("Authorization","Bearer "+UserLoginController.Bearer_Token);
	}
	@When("Admin sends HTTPS Request with endpoint mandatory fields and additional fields")
	public void admin_sends_https_request_with_endpoint_mandatory_fields_and_additional_fields() throws Exception   {
						response=request.when().log().all().spec(ReqestBuilder.PostCreateUser())
						.body(CreateUserPayload.data())
						.post();
	}
	//PostUserMandatoryFields					
	@When("Admin sends HTTPS Request with endpoint and existingValuesForUniqueFields")
	public void admin_sends_https_request_with_endpoint_and_existing_values_for_unique_fields() throws Exception {
		response=request.when().log().all().spec(ReqestBuilder.PostCreateUser())
				.body(CreateUserPayload.data())
				.post();
				
	}
	
	@Then("Admin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).and()
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/CreateUser.JSON")))
		.extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	    jsonPath = response.jsonPath();
		 User_id = jsonPath.getString("userId");
		 System.out.println("CraetedUser:" +User_id);
		 
	}
	//PostUserInvalidValues 
	@When("Admin sends HTTPS Request with endpoint and invalid values")
	public void admin_sends_https_request_with_endpoint_and_invalid_values() throws Exception {
		response=request.when().log().all().spec(ReqestBuilder.PostCreateUser())
				.body(CreateUserPayload.Invaliddata())
				.post();
	}
	//PostUserMissingValues 
	@When("Admin sends HTTPS Request with endpoint and with missing mandatory fields in request body")
	public void admin_sends_https_request_with_endpoint_and_with_missing_mandatory_fields_in_request_body() throws Exception {
		response=request.when().log().all().spec(ReqestBuilder.PostCreateUser())
				.body(CreateUserPayload.Missingdata())
				.post();
	}
		
	@Then("Admin receives {int} Bad Request Status with error message.")
	public void admin_receives_bad_request_status_with_error_message(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//PostUserNoAuth
	@Given("Admin creates POST request with No Auth")
	public void admin_creates_post_request_with_No_Auth() {
		request= RestAssured.given();
	   	}

	@Then("Admin receives status {int} with Unauthorized message")
	public void admin_receives_status_with_unauthorized_message(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}

	//GetAllRoles
	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {
		
		request= RestAssured.given().header("Authorization","Bearer "+UserLoginController.Bearer_Token);
	}

	@When("Admin sends HTTPS Request with GET All Roles endpoint")
	public void admin_sends_https_request_with_get_all_roles_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.GetAllRoles()).get();
	}

	@Then("Admin receives {int} OK")
	public void admin_receives_ok(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//GetAllRoles-InvalidEndpoint
	@When("Admin sends HTTPS Request with invalid1 endpoint1")
	public void admin_sends_https_request_with_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetAllRoles()).get();
	}

	@Then("Admin receives status {int} with Not Found error message	Negative")
	public void admin_receives_status_with_not_found_error_message_negative(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//GetAllRoles,GrtAllUsers NoAuth
	@Given("Admin creates GET Request with No Auth")
	public void admin_creates_get_request_with_no_auth() {
		request= RestAssured.given();
	}

	//GetAllUsers
	@When("Admin sends HTTPS Request with GET All Users endpoint")
	public void admin_sends_https_request_with_get_all_users_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.GetAllRoles()).get();
	}
    //GetAllUsers-InvalidEndpoint
	@When("Admin sends HTTPS Request GET All Users with invalid1 endpoint1")
	public void admin_sends_https_request_get_all_users_with_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetAllUsers()).get();
	}
    //GetCountOfActiveandInactiveUsers
	@When("Admin sends HTTPS Request GET Count Of ActiveandInactive Users")
	public void admin_sends_https_request_get_count_of_activeand_inactive_users() {
		response = request.when().log().all().spec(ReqestBuilder.GetCount()).get();
	}
	//GetCountOfActiveandInactiveUsers-InvalidEndpoint
	@When("Admin sends HTTPS Request GET Count Of ActiveandInactive Users with invalid1 endpoint1")
	public void admin_sends_https_request_get_count_of_activeand_inactive_users_with_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetCount()).get();
	}
	//GetCountOfActiveandInactiveUsersbyValidRoleId
	@When("Admin sends HTTPS Request with Valid roleId")
	public void admin_sends_https_request_with_valid_role_id() {
		response = request.when().log().all().queryParam("id","R01").spec(ReqestBuilder.GetCount()).get();
	}
	//GetCountOfActiveandInactiveUsersbyInvalidRoleId
	@When("Admin sends HTTPS Request with invalid rolrId")
	public void admin_sends_https_request_with_invalid_rolr_id() {
		response = request.when().log().all().queryParam("id","R05").spec(ReqestBuilder.GetCount()).get();
	}
	//GetUserbyValidRoleID
	@When("Admin sends HTTPS Request with endpoint and valid role ID")
	public void admin_sends_https_request_with_endpoint_and_valid_role_id() {
		response = request.when().log().all().pathParam("roleId","R02").spec(ReqestBuilder.GetUSerbyRoleID()).get();
	}
	//@GetUserbyInvalidRoleID
	@When("Admin sends HTTPS Request with endpoint and Invalid role ID")
	public void admin_sends_https_request_with_endpoint_and_invalid_role_id() {
		response = request.when().log().all().pathParam("roleId","R06").spec(ReqestBuilder.GetUSerbyRoleID()).get();
	}
	//@GetUserbyInvalidEndPoint
	@When("Admin sends HTTPS Request with invalid1 endpoint1 and valid role ID")
	public void admin_sends_https_request_with_invalid_endpoint_and_valid_role_id() {
		response = request.when().log().all().pathParam("roleId","R02").spec(ReqestBuilder.InvalidGetUSerbyRoleID()).get();
	}
	//GetUserbyValidUserId
		@When("Admin sends HTTPS Request with valid endpoint and  valid UserId")
		public void admin_sends_https_request_with_valid_endpoint_and_valid_user_id() {
			response = request.when().log().all().pathParam("id",User_id).spec(ReqestBuilder.GetUSerbyUserID()).get();
		}
		//GetUserbyInvalidUserID
		@When("Admin sends HTTPS Request with valid endpoint and  Invalid UserId")
		public void admin_sends_https_request_with_valid_endpoint_and_invalid_user_id() {
			response = request.when().log().all().pathParam("id","1509").spec(ReqestBuilder.GetUSerbyUserID()).get();
		    
		}
		//GetUserbyUserIDInavalidEndPoint
		@When("Admin sends HTTPS Request with invalid1 endpoint1 and valid UserId")
		public void admin_sends_https_request_with_invalid_endpoint_and_valid_user_id() {
			response = request.when().log().all().pathParam("id",User_id).spec(ReqestBuilder.InvalidGetUSerbyUserID()).get();
		    
		}
	//GetAllUserswithRoles
	@When("Admin sends HTTPS Request to GET All UserswithRoles with valid endpoint")
	public void admin_sends_https_request_to_get_all_userswith_roles_with_valid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.GetUSerwithRoles()).get();
	}
	//GetAllUserswithRolesInvalidendpoint
	@When("Admin sends HTTPS Request to GET All UserswithRoles with invalid1 endpoint1")
	public void admin_sends_https_request_to_get_all_userswith_roles_with_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetAllUserswithroles()).get();
	}
	//GetallActiveUser 
	@When("Admin sends HTTPS Request with GET All ActiveUsers endpoint")
	public void admin_sends_https_request_with_get_all_active_users_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.GetAllActiveUsers()).get();
	}
	// @GetAllActiveUsers-InvalidEndpoint
	@When("Admin sends HTTPS Request GET All ActiveUsers with invalid1 endpoint1")
	public void admin_sends_https_request_get_all_active_users_with_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetAllAvtiveUsers()).get();
	}
	//GetallUserswithFacets/Filters
	@When("Admin sends HTTPS Request with GET All Users withFacets\\/Filters endpoint")
	public void admin_sends_https_request_with_get_all_users_with_facets_filters_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.GetAllUsersWithFilters()).get();
	}
	//@GetAllActiveUsers-InvalidEndpoint
	@When("Admin sends HTTPS Request GET All Users withFacets\\/Filters invalid1 endpoint1")
	public void admin_sends_https_request_get_all_users_with_facets_filters_invalid_endpoint() {
		response = request.when().log().all().spec(ReqestBuilder.InvalidGetAllUsersWithFilters()).get();
	}
    //PutUpdateUserRoleIdwithValidUserId

     @Given("Admin creates PUT Request")
     public void admin_creates_put_request() {
    	 request= RestAssured.given().header("Authorization","Bearer "+UserLoginController.Bearer_Token);
     }

     @When("Admin sends HTTPS Request with endpoint, valid request body and valid UserId")
      public void admin_sends_https_request_with_endpoint_valid_request_body_and_valid_user_id() {
    	 String roleJson = "{\"userRoleList\": ["
    	 		+ "    \"R02\""
    	 		+ "  ]}";
    	 response=request.when().log().all().spec(ReqestBuilder.UpdateUserRole())
    			 .pathParam("userId",User_id).body(roleJson).put();
 			
      }

      @Then("Admin receives {int} OK  Status with response body.")
      public void admin_receives_ok_status_with_response_body(Integer int1) {
    	 response.prettyPrint();
  		response.then().assertThat().statusCode(int1).extract().response().asString();
  		int statuscode=response.getStatusCode();
  	    System.out.println("Statuscode:" +statuscode);
      }
      //PutUpdateUserInvalidRoleIdwithValidUserId
      @When("Admin sends HTTPS Request with endpoint, valid request body and Invalid UserId")
      public void admin_sends_https_request_with_endpoint_valid_request_body_and_invalid_user_id() {
    	  String roleJson = "{\"userRoleList\": ["
      	 		+ "    \"R03\""
      	 		+ "  ]}";
      	 response=request.when().log().all().spec(ReqestBuilder.UpdateUserRole())
      			 .pathParam("userId","1509").body(roleJson).put();
   			
      }
      // @PutUpdateUserRoleIdwithValidUserIdInvalidEndpoint
      @When("Admin sends HTTPS Request with invalid1 endpoint1, valid request body and valid UserId")
      public void admin_sends_https_request_with_invalid_endpoint_valid_request_body_and_valid_user_id() {
    	  String roleJson = "{\"userRoleList\": ["
      	 		+ "    \"R02\""
      	 		+ "  ]}";
      	 response=request.when().log().all().spec(ReqestBuilder.InvalidUpdateUserRole())
      			 .pathParam("userId",User_id).body(roleJson).put();
      }
      @Then("Admin receives {int} Bad Request Status with message and Boolean1 success details")
      public void admin_receives_bad_request_status_with_message_and_Boolean1_success_details(Integer int1) {
    	    response.prettyPrint();
    		response.then().assertThat().statusCode(int1).extract().response().asString();
    		int statuscode=response.getStatusCode();
    	    System.out.println("Statuscode:" +statuscode);
      }
      // @PutUpdateUserInvalidRoleIdwithValidUserId
      @When("Admin sends HTTPS Request with endpoint, invalid request body and valid UserId")
      public void admin_sends_https_request_with_endpoint_invalid_request_body_and_valid_user_id() {
    	  String roleJson = "{\"userRoleList\": ["
        	 		+ "    \"R05\""
        	 		+ "  ]}";
        	 response=request.when().log().all().spec(ReqestBuilder.UpdateUserRole())
        			 .pathParam("userId",User_id).body(roleJson).put();
      }
      //@PutUpdateUserExistingRoleIdwithValidUserId
      @When("Admin sends HTTPS Request with endpoint, existing RoleId and valid UserId")
      public void admin_sends_https_request_with_endpoint_existing_role_id_and_valid_user_id() {
    	  String roleJson = "{\"userRoleList\": ["
      	 		+ "    \"R02\""
      	 		+ "  ]}";
      	 response=request.when().log().all().spec(ReqestBuilder.UpdateUserRole())
      			 .pathParam("userId",User_id).body(roleJson).put();
      }
      
      //UpdateUserRoleStatusvaliddata
      @When("Admin sends HTTPS Request with endpointand valid data in request body")
      public void admin_sends_https_request_with_endpointand_valid_data_in_request_body() {
    	  String roleStatusJson = "{\"roleId\": \"R02\", \"userRoleStatus\": \"Active\"}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleStatus())
       			 .pathParam("userId",User_id).body(roleStatusJson).put();   
      }
      //UpdateUserRoleStatusinvaliddata 
      @When("Admin sends HTTPS Request with endpointand invalid data in request body")
      public void admin_sends_https_request_with_endpointand_invalid_data_in_request_body() {
    	  String roleStatusJson = "{\"roleId\": \"R05\", \"userRoleStatus\": \"Active\"}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleStatus())
       			 .pathParam("userId",User_id).body(roleStatusJson).put();
      }
      //UpdateUserRoleStatusinvalidUserId 

      @When("Admin sends HTTPS Request with endpoint valid data,Invalid userId in request body")
      public void admin_sends_https_request_with_endpoint_valid_data_invalid_user_id_in_request_body() {
    	  String roleStatusJson = "{\"roleId\": \"R05\", \"userRoleStatus\": \"Active\"}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleStatus())
       			 .pathParam("userId","1509").body(roleStatusJson).put();
      }
      //UpdateUserRoleStatusnonexisting/unassignedRoleID
      @When("Admin sends HTTPS Request with endpoint valid data,valid userId,nonexisting\\/unassigned RoleID in request body")
      public void admin_sends_https_request_with_endpoint_valid_data_valid_user_id_nonexisting_unassigned_role_id_in_request_body() {
    	  String roleStatusJson = "{\"roleId\": \"R01\", \"userRoleStatus\": \"Active\"}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleStatus())
       			 .pathParam("userId",User_id).body(roleStatusJson).put();
      }
      //UpdateUserRoleStatusInvalidEndpoint
      @When("Admin sends HTTPS Request with invalid1 endpoint1 and valid data in request body")
      public void admin_sends_https_request_with_invalid_endpoint_and_valid_data_in_request_body() {
    	  String roleStatusJson = "{\"roleId\": \"R05\", \"userRoleStatus\": \"Active\"}";
    	  response=request.when().log().all().spec(ReqestBuilder.InvalidUpdateUserRoleStatus())
       			 .pathParam("userId",User_id).body(roleStatusJson).put();
      }
      
      //@UpdateAdminRoleProgramBatchstatusValidData
      @When("Admin sends HTTPS Request with endpoint and valid data in request body")
      public void admin_sends_https_request_with_endpoint_and_valid_data_in_request_body() {
    	  String PBStatusJson = "{\"programId\": \"16595\", "
    			    + "\"roleId\": \"R02\","
    			    + "\"userId\": \"U1509\","
    			    + "\"userRoleProgramBatches\": ["
    			    + "{\"batchId\": \"8603\","
    			    + "\"userRoleProgramBatchStatus\": \"Active\"}]}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleProgramBatchStatus())
        			 .pathParam("userId",User_id).body(PBStatusJson).put();
      }
      @Then("Admin receives {int} Ok Status with response message")
      public void admin_receives_ok_status_with_response_message(Integer int1) {
    	  response.prettyPrint();
  		response.then().assertThat().statusCode(int1).extract().response().asString();
  		int statuscode=response.getStatusCode();
  	    System.out.println("Statuscode:" +statuscode);
      }
      //@UpdateAdminRoleProgramBatchstatusInValidData
      @When("Admin sends HTTPS Request with endpoint and invalid data in request body")
      public void admin_sends_https_request_with_endpoint_and_invalid_data_in_request_body() {
    	  String PBStatusJson = "{\"programId\": \"16692\", "
  			    + "\"roleId\": \"R00\","
  			    + "\"userId\": \"U1509\","
  			    + "\"userRoleProgramBatches\": ["
  			    + "{\"batchId\": \"9274\","
  			    + "\"userRoleProgramBatchStatus\": \"Active\"}]}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleProgramBatchStatus())
     			 .pathParam("userId",User_id).body(PBStatusJson).put();
      }
      //UpdateAdminRoleProgramBatchstatusInValidUserId
      @When("Admin sends HTTPS Request with endpoint,valid data in request body and Invalid UserId")
      public void admin_sends_https_request_with_endpoint_valid_data_in_request_body_and_invalid_user_id() {
    	  String PBStatusJson = "{\"programId\": \"16692\", "
  			    + "\"roleId\": \"R02\","
  			    + "\"userId\": \"U1509\","
  			    + "\"userRoleProgramBatches\": ["
  			    + "{\"batchId\": \"9274\","
  			    + "\"userRoleProgramBatchStatus\": \"Active\"}]}";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserRoleProgramBatchStatus())
     			 .pathParam("userId","1627").body(PBStatusJson).put();
      }
      //UpdateAdminRoleProgramBatchstatusInvalidEndPoint
      @When("Admin sends HTTPS Request with invalid1 endpoint1 and valid ProgramBatchstatus in request body")
      public void admin_sends_https_request_with_invalid1_endpoint1_and_valid_program_batchstatus_in_request_body() {
    	  String PBStatusJson = "{\"programId\": \"16692\", "
    			    + "\"roleId\": \"R02\","
    			    + "\"userId\": \"U1627\","
    			    + "\"userRoleProgramBatches\": ["
    			    + "{\"batchId\": \"9274\","
    			    + "\"userRoleProgramBatchStatus\": \"Active\"}]}";
    	  response=request.when().log().all().spec(ReqestBuilder.InvalidUpdateUserRoleProgramBatchStatus())
     			 .pathParam("userId",User_id).body(PBStatusJson).put();
      }
      //@UpdateAdminloginstatusValiddata
      @When("Admin sends HTTPS Request with endpoint valid data for login status in request body")
      public void admin_sends_https_request_with_endpoint_valid_data_for_login_status_in_request_body() {
    	  String loginStatusJson = "{\"loginStatus\": \"Active\", "
    			  + "\"roleIds\": ["
    			  + "\"R02\""
    			  + "],"
    			  + "\"status\": \"Active\","
    			  + "\"userLoginEmail\":\"Updatedmail400@gmail.com\" }";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserLoginStatus())
      			 .pathParam("userId",User_id).body(loginStatusJson).put();
      }
      //@UpdateAdminloginstatusInValidData
      @When("Admin sends HTTPS Request with endpoint invalid data for login status in request body")
      public void admin_sends_https_request_with_endpoint_invalid_data_for_login_status_in_request_body() {
    	  String loginStatusJson = "{\"loginStatus\": \"Actives\", "
    			  + "\"roleIds\": ["
    			  + "\"R05\""
    			  + "],"
    			  + "\"status\": \"ctive\","
    	
    			  + "\"userLoginEmail\":\"Updatedemail@gmail.com\" }";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserLoginStatus())
      			 .pathParam("userId",User_id).body(loginStatusJson).put();
      }
      //@UpdateAdminloginstatusInValidUserId
      @When("Admin sends HTTPS Request with endpoint invalid UserId for login status in request body")
      public void admin_sends_https_request_with_endpoint_invalid_user_id_for_login_status_in_request_body() {
    	  String loginStatusJson = "{\"loginStatus\": \"Active\", "
    			  + "\"roleIds\": ["
    			  + "\"R02\""
    			  + "],"
    			  + "\"status\": \"Active\","
    			  + "\"userLoginEmail\":\"Updatedemail005@gmail.com\" }";
    	  response=request.when().log().all().spec(ReqestBuilder.UpdateUserLoginStatus())
      			 .pathParam("userId","1654").body(loginStatusJson).put();
      }


	@When("Admin sends HTTPS request with endpoiint with Valid ID")
	public void admin_sends_https_request_with_endpoiint_with_valid_id() {
		response = request.when().pathParam("userID",User_id).spec(ReqestBuilder.DeleteUser()).delete();
		}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//UpdateUserInfoValiddata
	@When("Admin sends HTTPS request with endpoiint and valid data in request body \\(values only in all fields)")
	public void admin_sends_https_request_with_endpoiint_and_valid_data_in_request_body_values_only_in_all_fields() throws Exception {
		String InfoJson="{\"userComments\": \"test\", "
				+ "\"userEduPg\": \"MCA\","
				+ " \"userEduUg\": \"BCA\", "
				+ "\"userFirstName\": \"Red\","
				+ " \"userLastName\": \"Rose\","
				+ " \"userLinkedinUrl\": \"www.linkedin.com\","
				+ " \"userLocation\": \"CANADA\","
				+ " \"userLoginEmail\": \"red17@yopmail.com\", "
				+ "\"userMiddleName\": \"Flowers\","
				+ " \"userPhoneNumber\": 2099957424,"
				+ " \"userTimeZone\": \"CST\","
				+ " \"userVisaStatus\": \"H4\"}";
		response = request.when().pathParam("userId",User_id)
				.spec(ReqestBuilder.UpdateUserInfo()).body(InfoJson).put();
	}
	//UpdateUserInfoInvaliddata
	@When("Admin sends HTTPS request with endpoiint and Invalid data in request body")
	public void admin_sends_https_request_with_endpoiint_and_invalid_data_in_request_body() {
		String InfoJson="{\"userComments\": \"test\", "
				+ "\"userEduPg\": \"MC08A\","
				+ " \"userEduUg\": \"B(()CA\", "
				+ "\"userFirstName\": \"R12ed\","
				+ " \"userLastName\": \"Ro32se\","
				+ " \"userLinkedinUrl\": \"www.linkedin.com\","
				+ " \"userLocation\": \"CANADA\","
				+ " \"userLoginEmail\": \"red11yopmail.com\", "
				+ "\"userMiddleName\": \"Flowers\","
				+ " \"userPhoneNumber\": 21565872,"
				+ " \"userTimeZone\": \"CST\","
				+ " \"userVisaStatus\": \"H4\"}";
		response = request.when().pathParam("userId",User_id)
				.spec(ReqestBuilder.UpdateUserInfo()).body(InfoJson).put();
	}
	//UpdateUserInfoInvalidUserId
	@When("Admin sends HTTPS request with endpoiint,valid data in request body and Invalid UserId")
	public void admin_sends_https_request_with_endpoiint_valid_data_in_request_body_and_invalid_user_id() {
		String InfoJson="{\"userComments\": \"test\", "
				+ "\"userEduPg\": \"MCA\","
				+ " \"userEduUg\": \"BCA\", "
				+ "\"userFirstName\": \"Red\","
				+ " \"userLastName\": \"Rose\","
				+ " \"userLinkedinUrl\": \"www.linkedin.com\","
				+ " \"userLocation\": \"CANADA\","
				+ " \"userLoginEmail\": \"red12@yopmail.com\", "
				+ "\"userMiddleName\": \"Flowers\","
				+ " \"userPhoneNumber\": 2157458872,"
				+ " \"userTimeZone\": \"CST\","
				+ " \"userVisaStatus\": \"H4\"}";
		response = request.when().pathParam("userId","1509")
				.spec(ReqestBuilder.UpdateUserInfo()).body(InfoJson).put();
	}
	//@UpdateUserInfoNoAuth
	@Given("Admin creates PUT Request with No Auth")
	public void admin_creates_put_request_with_no_auth() {
		request= RestAssured.given();
	}
		
	//DeleteInvalidId
	@When("Admin sends HTTPS request with endpoiint with InValid ID")
	public void admin_sends_https_request_with_endpoiint_with_Invalid_id() {
		response = request.when().pathParam("userID","A455").spec(ReqestBuilder.DeleteUser()).delete();
	}
	@Then("Admin receives status {int} with Not Found error message")
	public void admin_receives_status_with_not_found_error_message(Integer int1) {
		response.prettyPrint();
		response.then().assertThat().statusCode(int1).extract().response().asString();
		int statuscode=response.getStatusCode();
	    System.out.println("Statuscode:" +statuscode);
	}
	//DeleteValidId
		@Given("Admin creates DELETE Request to delete Admin details")
		public void admin_creates_delete_request_to_delete_admin_details() {
			request= RestAssured.given().header("Authorization","Bearer "+UserLoginController.Bearer_Token);
		}


}
