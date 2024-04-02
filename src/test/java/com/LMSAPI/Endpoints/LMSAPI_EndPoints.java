package com.LMSAPI.Endpoints;

import io.restassured.specification.RequestSpecification;

public class LMSAPI_EndPoints {
	
	public static final String BASE_URL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static final String Invalid_BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com";
	
	//UserLogin Controller-Post Sign In
		public static final String User_Sign_In ="/login";
		public static final String Invalid_User_Sign_In ="/logins";
	
	//UserLogin
	public static final String User_Login ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/login";
	
	//ProgramController EndPoints
	
	public static final String Create_New_Program = "/saveprogram";			
	public static final String Get_All_Programs = BASE_URL+"/allPrograms";
	public static final String Get_All_ProgramsWithUsers = BASE_URL+"/allProgramsWithUsers";			
	public static final String Get_Program_By_ID =BASE_URL+ "/programs/{programId}";
	public static final String Update_Program_By_ProgramName = "/program/{programName}";
	public static final String Update_Program_By_ProgramID = "/putprogram/{programId}";
	public static final String Delete_Program_By_ProgramID = BASE_URL+"/deletebyprogid/1 6 5 9 4";
	public static final String Delete_Program_By_ProgramName =BASE_URL+ "/deletebyprogname/{programName}";
	public static final String NoAuth_Delete_Program_By_ProgramID = BASE_URL+"/deletebyprogid/{programId}";
	public static final String Delete_Program_By_ProgramID1 = BASE_URL+"/deletebyprogid/{programId}";
	//Invalid PromramController EndPoints
	
	public static final String Invalid_Create_New_Program = "/saveprograms";
	public static final String InvalidEndPoint_Get_All_Programs = BASE_URL+"/allProgram";
	public static final String InvalidEndPoint_Get_All_ProgramsWithUsers = BASE_URL+"/allProgramsWithUser";			
	public static final String InvalidEndPoint_Get_Program_By_ID = BASE_URL+"/program/16685";
	public static final String Invalid_Update_Program_By_ProgramName = "/programs/{programName}";
	public static final String Invalid_Update_Program_By_ProgramID = "/putprograms/{programId}";
	public static final String Update_Program_By_InvalidProgramID =BASE_URL+"/putprograms/134";
	public static final String Invalid_Delete_Program_By_ProgramID = BASE_URL+"/deletebyprogids/123";
	public static final String Invalid_Delete_Program_By_ProgramName = BASE_URL+"/deletebyprognames/dsfj2435#$%";
	
	//Invalid PromramController BaseUrl
	public static final String InvalidBaseURL_Create_Program = Invalid_BASE_URL+"/saveprogram";
	public static final String InvalidBaseURL_Get_All_Programs = Invalid_BASE_URL+"/allProgram";
	public static final String InvalidBaseURL_Get_Program_By_ID =Invalid_BASE_URL+"/program/16685";
	public static final String InvalidBaseURL_Get_All_Pgms_WithUsers =Invalid_BASE_URL+"/allProgramsWithUsers";
	public static final String InvalidBaseURL_Delete_Program_By_ProgramID = Invalid_BASE_URL+"/deletebyprogid/16677";
	public static final String InvalidBaseURL_Delete_Program_By_ProgramName =Invalid_BASE_URL+"/deletebyprogname/team9RestASSuredHackathonMarch2056_SDET6";
	public static final String validBaseURL_Get_Program_By_ID =BASE_URL+"/program/16685";
	
	//Invalid Method ProgramController
	public static final String InvalidMethod_Delete_Program_By_ProgramName =BASE_URL+ "/deletebyprogname/team9sdet139";
	public static final String InvalidMethod_Delete_Program_By_ProgramId =BASE_URL+ "/deletebyprogname/team9sdet139";
		
	//ProgramBatchController EndPoints
	
	public static final String Create_New_Programbatch = "/batches";			
	public static final String Get_All_Programsbatches = BASE_URL+"/batches";	
	public static final String Get_Programbatch_By_ID = BASE_URL+"/batches/batchId/{batchId}";
	public static final String Get_Programbatch_By_BatchName =BASE_URL+"/batches/batchName/{batchName}";
	public static final String Get_ProgramID_By_ID = BASE_URL+"/batches/program/{programId}";
	public static final String Update_Programbatch_By_ProgramName = "/program/{programName}";
	public static final String Update_Programbatch_By_batchID = "/batches/{batchId}";
	public static final String Delete_Programbatch_By_ProgramID = "/deletebyprogid/{programId}";
	public static final String Delete_Programbatch_By_ProgramName = "/deletebyprogname/{programName}";
	
	//Invalid PromramBatchController EndPoints
	
	public static final String Invalid_Create_New_ProgramBatch = "/batch";
	public static final String Invalid_Get_All_Programsbatches = BASE_URL+"/batch";
	public static final String Invalid_Get_Programbatch_By_ID = BASE_URL+"/batch/batchId/{batchId}";
	public static final String Invalid_Get_Programbatch_By_BatchName=BASE_URL+"/batch/batchName/{batchName}";
	public static final String Invalid_Get_ProgramID_By_ID = BASE_URL+"/batch/program/{programId}";
	public static final String Invalid_Update_Programbatch_By_batchID = "/batch/{batchId}";
	
	//UserLogin Controller-Post Log Out
	public static final String User_LogOut ="/logoutlms";
	public static final String Invalid_User_LogOut ="/logoutms";
	//User Controller-Post Create User
	public static final String Create_User ="/users/roleStatus";
	public static final String Invalid_Create_User ="/user/roleStatus";
	//User Controller-Get All Roles
	public static final String Get_All_Roles ="/roles";
	public static final String Invalid_Get_All_Roles ="/Roles";
	//User Controller-Get All Users
	public static final String Get_All_Users ="/users";
	public static final String Invalid_Get_All_Users ="/user";
	//User Controller-Get CountOfActiveandInactiveUsers
	public static final String Get_count ="/users/byStatus";
	public static final String Invalid_Get_count ="/user/byStatus";
	//User Controller-Get UserbyUserId
	public static final String Get_User_byUserID ="/users/{id}";
	public static final String Invalid_Get_User_byUserID="/user/{id}";
	//User Controller-Get UserbyRoleId
	public static final String Get_User_byroleID ="/users/roles/{roleId}";
	public static final String Invalid_Get_User_byroleID="/user/roles/{roleId}";
	//User Controller-Get All Users with Roles
	public static final String Get_All_UserswithRoles ="/users/roles";
	public static final String Invalid_Get_All_Userswithroles ="/user/roles";
	//User Controller-Get All ActiveUsers
	public static final String Get_All_ActiveUsers ="/users/activeUsers";
	public static final String Invalid_Get_All_ActiveUsers ="/user/activeUsers";
	//User Controller-Get AllUsers withFacets/Filters
	public static final String Get_AllUsers_withFilters ="/v2/users";
	public static final String Invalid_Get_AllUsers_withFilters="/v1/users";
	//User Controller-Update UserRole
	public static final String Update_UserRole ="/users/roleId/{userId}";
	public static final String Invalid_Update_UserRole ="/user/roleId/{userId}";
	//User Controller-Update UserRoleStatus
	public static final String Update_UserRoleStatus ="/users/roleStatus/{userId}";
	public static final String Invalid_Update_UserRoleStatus ="/user/roleStatus/{userId}";
	//User Controller-Update UserRoleProgramBatchStatus
	public static final String Update_UserRoleProgramBatchStatusStatus ="/users/roleProgramBatchStatus/{userId}";
	public static final String Invalid_Update_UserRoleProgramBatchStatusStatus ="/user/roleProgramBatchStatus/{userId}";
	//User Controller-Update UserLoginStatus
	public static final String Update_UserLoginStatus ="/users/userLogin/{userId}";
	public static final String Invalid_Update_UserLoginStatus ="/user/userLogin/{userId}";
	//User Controller-Update UserInfo
	public static final String Update_UserInfo ="/users/{userId}";
	public static final String Invalid_Update_UserInfo="/user/{userId}";
		
	
	//User Controller-Delete /User
	public static final String Delete_User =" /users/{userID}"; 
	public static String Excelpath = "./src/test/resources/Testdata/LMS.xlsx";
	
	//UserRoleProgramBatchMapController EndPoints
	
		public static final String Get_all_program_users =BASE_URL+ "/userRoleProgramBatchMap";
		public static final String Get_all_program_user_by_ID = BASE_URL+"/userRoleProgramBatchMap/{userId}";
		public static final String Delete_all_programs_by_ID = BASE_URL+"/userRoleProgramBatchMap/deleteAll/{userId}";
		
		//UserRoleProgramBatchMapController Invalid EndPoints
		
		public static final String Invalid_Get_all_program_users =BASE_URL+ "/userRoleProgramBatchMaps";
		public static final String Invalid_Get_all_program_user_by_ID = BASE_URL+"/userRoleProgramBatchMaps/{userId}";
		public static final String Invalid_Delete_all_programs_by_ID = BASE_URL+"/userRoleProgramBatchMaps/deleteAll/{userId}";
	

}

