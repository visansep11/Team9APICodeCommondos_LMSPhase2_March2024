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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class ProgramBatchPayload {
		public static List<Map<String, String>> excelinput;
		public static PathReader path = new PathReader();
		public static String requestBody;
//		public static List<Response> responses = new ArrayList<>();
		public static Response response;
		
		public static List<String> PostCreateProgramBatchRequest() throws InvalidFormatException, IOException {
			 List<String> requestBodies = new ArrayList<>();
//			    List<Response> responses = new ArrayList<>();
			
			excelinput = UserExcelUtility.getData(path.bundle.getString("excelFilePath"),"Sheet2");
	       System.out.println(excelinput);

			for(int i=0;i<excelinput.size();i++) {
				
				 requestBody = "{\n" +
		                   "  \"batchDescription\": \"" + excelinput.get(i).get("batchDescription") + "\",\n" +
		                   "  \"batchName\": \"" + excelinput.get(i).get("batchName") + "\",\n" +
		                   "  \"batchNoOfClasses\": \"" + excelinput.get(i).get("batchNoOfClasses") + "\",\n" +
		                   "  \"batchStatus\": \"" + excelinput.get(i).get("batchStatus") + "\",\n" +
		                   "  \"programId\": \"" + excelinput.get(i).get("programId") + "\"\n" +
		                   "}";
				 requestBodies.add(requestBody);
				
//		            responses.add(response);

			 }
//			 System.out.println("The size of my response list is:"+responses.size());
			 System.out.println("requestBodies1 :" +requestBodies);
			 return requestBodies;

			 //return response;
			
		}
		
		public static String PostCreateProgramBatchRequest_Invalid() throws IOException {
			requestBody = FileUtils.readFileToString(new File(FileNameConstants.PostCreateProgramBatchInvalid_API_REQUEST_BODY),
					"UTF-8");
			System.out.println("Request Body :" + requestBody );
			return requestBody;
					
		}	
		

}
