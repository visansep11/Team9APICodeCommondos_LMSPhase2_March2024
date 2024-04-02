package com.LMSAPI.PayLoad;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Pojo.CreateUserPojo;
import com.LMSAPI.Pojo.CreateUser_userLogin;
import com.LMSAPI.Pojo.CreateUser_userRoleMaps;
import com.LMSAPI.Utilities.*;
import com.LMSAPI.Utilities.UserExcelUtility;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUserPayload {
	
	public static String data() throws Exception {
	 
	 CreateUserPojo data=new CreateUserPojo();
	 List<CreateUser_userRoleMaps> data3=new ArrayList<>();
		
		
   List<Map<String, String>> getUserData = (UserExcelUtility.getData(LMSAPI_EndPoints .Excelpath, "LMSValidData"));
	
		 for (Map<String, String> row : getUserData){
			 
			    String userComments = row.get("userComments");
			    String userEduPg = row.get("userEduPg");
				String userEduUg = row.get("userEduUg");
				String userFirstName = row.get("userFirstName");
				String userLastName = row.get("userLastName");
				String userLinkedinUrl = row.get("userLinkedinUrl");
				String userLocation = row.get("userLocation");
				String userMiddleName = row.get("userMiddleName");
				String userPhoneNumber = row.get("userPhoneNumber");
				System.out.println(userPhoneNumber);
		        long userPhoneNumber1 = Long.parseLong(userPhoneNumber);
				String userTimeZone = row.get("userTimeZone");
				String userVisaStatus = row.get("userVisaStatus");
				String loginStatus = row.get("loginStatus");
			    String userLoginEmail = row.get("userLoginEmail");
			    String roleId = row.get("roleId");
				String userRoleStatus = row.get("userRoleStatus");
				String status = row.get("Status");
				
				
				 data.setUserComments(userComments);
				 data.setUserEduPg(userEduPg);
		         data.setUserEduUg(userEduUg);
				 data.setUserFirstName(userFirstName);
				 data.setUserLastName(userLastName);
				 data.setUserLinkedinUrl(userLinkedinUrl);
				 data.setUserLocation(userLocation);
				 
				 CreateUser_userLogin userLogin=new CreateUser_userLogin();
				 userLogin.setLoginStatus(loginStatus);
				 userLogin.setStatus(status);
				 userLogin.setUserLoginEmail(userLoginEmail);
				 data.setUserLogin(userLogin);
				 
				 data.setUserMiddleName(userMiddleName);
				 data.setUserPhoneNumber(userPhoneNumber1);
				 
				 CreateUser_userRoleMaps data2=new  CreateUser_userRoleMaps();
				 data2.setRoleId(roleId);
				 data2.setUserRoleStatus(userRoleStatus);
				 data3.add(data2);
							   
				data.setUserRoleMaps(data3);
				
			    data.setUserTimeZone(userTimeZone);
			    data.setUserVisaStatus(userVisaStatus);
			    ObjectMapper objectMapper = new ObjectMapper();
		        String json = objectMapper.writeValueAsString(data);
		        System.out.println(json);
		        return json ;
			
				 }
		return null;
		 
	}
	public static String Invaliddata() throws Exception {
		 
		 CreateUserPojo data=new CreateUserPojo();
		 List<CreateUser_userRoleMaps> data3=new ArrayList<>();
			
			
	   List<Map<String, String>> getUserData = (UserExcelUtility.getData(LMSAPI_EndPoints .Excelpath, "LMSInvalidData"));
		
			 for (Map<String, String> row : getUserData){
				 
				    String userComments = row.get("userComments");
				    String userEduPg = row.get("userEduPg");
					String userEduUg = row.get("userEduUg");
					String userFirstName = row.get("userFirstName");
					String userLastName = row.get("userLastName");
					String userLinkedinUrl = row.get("userLinkedinUrl");
					String userLocation = row.get("userLocation");
					String userMiddleName = row.get("userMiddleName");
					String userPhoneNumber = row.get("userPhoneNumber");
					System.out.println(userPhoneNumber);
			        long userPhoneNumber1 = Long.parseLong(userPhoneNumber);
					String userTimeZone = row.get("userTimeZone");
					String userVisaStatus = row.get("userVisaStatus");
					String loginStatus = row.get("loginStatus");
				    String userLoginEmail = row.get("userLoginEmail");
				    String roleId = row.get("roleId");
					String userRoleStatus = row.get("userRoleStatus");
					String status = row.get("Status");
					
					
					data.setUserComments(userComments);
					data.setUserEduPg(userEduPg);
					data.setUserEduUg(userEduUg);
					data.setUserFirstName(userFirstName);
					data.setUserLastName(userLastName);
					data.setUserLinkedinUrl(userLinkedinUrl);
					data.setUserLocation(userLocation);
					 
					 CreateUser_userLogin userLogin=new CreateUser_userLogin();
					 userLogin.setLoginStatus(loginStatus);
					 userLogin.setStatus(status);
					 userLogin.setUserLoginEmail(userLoginEmail);
					data.setUserLogin(userLogin);
					 
					data.setUserMiddleName(userMiddleName);
					data.setUserPhoneNumber(userPhoneNumber1);
					 
					 CreateUser_userRoleMaps data2=new  CreateUser_userRoleMaps();
					 data2.setRoleId(roleId);
					 data2.setUserRoleStatus(userRoleStatus);
					 data3.add(data2);
								   
					data.setUserRoleMaps(data3);
					
					data.setUserTimeZone(userTimeZone);
					data.setUserVisaStatus(userVisaStatus);
				    ObjectMapper objectMapper = new ObjectMapper();
			        String json = objectMapper.writeValueAsString(data);
			        System.out.println(json);
			        return json ;
				
					 }
			return null;
			 
		}
	public static String Missingdata() throws Exception {
			 
			 CreateUserPojo data=new CreateUserPojo();
			 List<CreateUser_userRoleMaps> data3=new ArrayList<>();
				
				
		   List<Map<String, String>> getUserData = (UserExcelUtility.getData(LMSAPI_EndPoints .Excelpath, "MissingMandatory"));
			
				 for (Map<String, String> row : getUserData){
					 
					    String userComments = row.get("userComments");
					    String userEduPg = row.get("userEduPg");
						String userEduUg = row.get("userEduUg");
						String userFirstName = row.get("userFirstName");
						String userLastName = row.get("userLastName");
						String userLinkedinUrl = row.get("userLinkedinUrl");
						String userLocation = row.get("userLocation");
						String userMiddleName = row.get("userMiddleName");
						String userPhoneNumber = row.get("userPhoneNumber");
						System.out.println(userPhoneNumber);
				        long userPhoneNumber1 = Long.parseLong(userPhoneNumber);
						String userTimeZone = row.get("userTimeZone");
						String userVisaStatus = row.get("userVisaStatus");
						String loginStatus = row.get("loginStatus");
					    String userLoginEmail = row.get("userLoginEmail");
					    String roleId = row.get("roleId");
						String userRoleStatus = row.get("userRoleStatus");
						String status = row.get("Status");
						
						
						data.setUserComments(userComments);
						data.setUserEduPg(userEduPg);
						data.setUserEduUg(userEduUg);
						data.setUserFirstName(userFirstName);
						data.setUserLastName(userLastName);
						data.setUserLinkedinUrl(userLinkedinUrl);
						data.setUserLocation(userLocation);
						 
						 CreateUser_userLogin userLogin=new CreateUser_userLogin();
						 userLogin.setLoginStatus(loginStatus);
						 userLogin.setStatus(status);
						 userLogin.setUserLoginEmail(userLoginEmail);
						data.setUserLogin(userLogin);
						 
						data.setUserMiddleName(userMiddleName);
						data.setUserPhoneNumber(userPhoneNumber1);
						 
						 CreateUser_userRoleMaps data2=new  CreateUser_userRoleMaps();
						 data2.setRoleId(roleId);
						 data2.setUserRoleStatus(userRoleStatus);
						 data3.add(data2);
									   
						data.setUserRoleMaps(data3);
						
						data.setUserTimeZone(userTimeZone);
						data.setUserVisaStatus(userVisaStatus);
					    ObjectMapper objectMapper = new ObjectMapper();
				        String json = objectMapper.writeValueAsString(data);
				        System.out.println(json);
				        return json ;
					
						 }
				return null;
				 
			}
	}