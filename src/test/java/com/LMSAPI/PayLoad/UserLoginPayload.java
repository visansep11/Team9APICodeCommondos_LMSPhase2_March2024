package com.LMSAPI.PayLoad;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Pojo.UserLoginPojo;
import com.LMSAPI.StepDef.UserLoginController;
import com.LMSAPI.Utilities.ConfigReaderAndWriter;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class UserLoginPayload {
	
	ConfigReaderAndWriter configReaderObj;
    static Properties prop; 
	public static UserLoginPojo userLogin = new UserLoginPojo();
	public static UserLoginPojo userLogin1 = new UserLoginPojo();
	  
    
public UserLoginPayload() {    	//pass object through constructor
    	configReaderObj = new ConfigReaderAndWriter();
        prop = configReaderObj.init_prop();
        	
    }
   
    public static String userLogin () throws Exception {
    	Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\LMSAPIConfig.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }      
       	userLogin.setUserLoginEmailId(prop.getProperty("Username"));
    	userLogin.setPassword(prop.getProperty("Password"));
    	   	   	
    	ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userLogin);
		return json ;
	    }
    public static String userLogin1 () throws Exception {
    	Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\LMSAPIConfig.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
      	userLogin1.setUserLoginEmailId(prop.getProperty("InvalidUsername"));
    	userLogin1.setPassword(prop.getProperty("InvalidPassword"));
    	   	
    	ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(userLogin1);
		return json ;
    	 	
    }
    
}
     