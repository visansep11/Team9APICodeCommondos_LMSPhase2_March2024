package com.LMSAPI.PayLoad;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Utilities.FileNameConstants;
import com.LMSAPI.Utilities.PathReader;
import com.LMSAPI.Utilities.UserExcelUtility;
import com.ReqSpecBuilder.ReqestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramControllerPayload {
	public static List<Map<String, String>> excelinput;
	public static PathReader path = new PathReader();
	public static String requestBody;
//	public static List<Response> responses = new ArrayList<>();
	public static Response response;
		
	public static List<String> PostCreateProgramRequest() throws InvalidFormatException, IOException {
		 List<String> requestBodies = new ArrayList<>();
//		    List<Response> responses = new ArrayList<>();
		
		excelinput = UserExcelUtility.getData(path.bundle.getString("excelFilePath"),"Sheet1");
       System.out.println(excelinput);

		for(int i=0;i<excelinput.size();i++) {
			 requestBody = "{\n" +
	                   "  \"programDescription\": \"" + excelinput.get(i).get("programDescription") + "\",\n" +
	                   "  \"programName\": \"" + excelinput.get(i).get("programName") + "\",\n" +
	                   "  \"programStatus\": \"" + excelinput.get(i).get("programStatus") + "\"\n" +
	                   "}";
			 requestBodies.add(requestBody);
			
//	            responses.add(response);

		 }
		 
		 System.out.println("requestBodies1 :" +requestBodies);
		 return requestBodies;
		
	}
	
	public static List<String> GetProgramRequest() throws InvalidFormatException, IOException{
		List<String> programID = new ArrayList<>();
		excelinput = UserExcelUtility.getData(path.bundle.getString("excelFilePath"),"GetProgram");
	       System.out.println("ExcelInput is :" +excelinput);
	      
	       for(int i=0;i<excelinput.size();i++) {
	    	   Map<String, String> getRequest = excelinput.get(i); 
	    	   
	       }
		return programID;
		}
		
	public static List<String> PutCreateProgramRequest() throws InvalidFormatException, IOException {
		 List<String> requestBodies = new ArrayList<>();
		 List<String> programNames = new ArrayList<>();
//		String programName;
		excelinput = UserExcelUtility.getData(path.bundle.getString("excelFilePath"),"PutProgram");
      System.out.println(excelinput);

		for(int i=0;i<excelinput.size();i++) {
			String programName1 = excelinput.get(i).get("programName");
			 requestBody = "{\n" +
	                   "  \"programDescription\": \"" + excelinput.get(i).get("programDescription") + "\",\n" +
	                   "  \"programName\": \"" + excelinput.get(i).get("programName") + "\",\n" +
	                   "  \"programStatus\": \"" + excelinput.get(i).get("programStatus") + "\"\n" +
	                   "}";
			 requestBodies.add(requestBody);
			 programNames.add(programName1);
			 System.out.println("ProgramName is :" +programName1);
			//responses.add(response);
		 }
		 
		 System.out.println("UpdaterequestBodies :" +requestBodies);
		
		 return requestBodies;
	}
	
	public static String PostCreateProgramRequest_Invalid() throws IOException {
		requestBody = FileUtils.readFileToString(new File(FileNameConstants.PostCreateProgramInvalid_API_REQUEST_BODY),
				"UTF-8");
		System.out.println("Request Body :" + requestBody );
		return requestBody;
				
	}	
	
}


