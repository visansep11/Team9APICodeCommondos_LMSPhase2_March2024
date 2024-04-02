package com.ReqSpecBuilder;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Utilities.FileNameConstants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqestBuilder {

	
	private static RequestSpecBuilder requestSpec = new RequestSpecBuilder()
			.setBaseUri(LMSAPI_EndPoints.BASE_URL)
			.setContentType(ContentType.JSON);
	private static RequestSpecBuilder requestSpec_invalid = new RequestSpecBuilder()
			.setBaseUri(LMSAPI_EndPoints.Invalid_BASE_URL)
			.setContentType(ContentType.JSON);
	
	//ProgramController-Post
	public static RequestSpecification PostCreateProgram() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Create_New_Program).build();

	}
	public static RequestSpecification PutCreateProgramName() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Update_Program_By_ProgramName).build();

	}
	public static RequestSpecification PutCreateProgramID() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Update_Program_By_ProgramID).build();

	}
//	public static RequestSpecification PutCreateProgram_InvalidEndpoint() {
//
//		return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Create_New_Program).build();
//
//	}
	public static RequestSpecification PostCreateProgram_InvalidEndpoint() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Create_New_Program).build();

	}
	public static RequestSpecification PostCreateProgram_InvalidBaseUrl() {

		return requestSpec_invalid.setBasePath(LMSAPI_EndPoints.Create_New_Program).build();

	}
	//PutProgramControllerRequest
	public static String PutCreateProgramRequest() {

		String PutRequestBody = null;
		try {
			PutRequestBody = FileUtils.readFileToString(new File(FileNameConstants.PutProgramrequest),
					"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("PutRequestBody :" + PutRequestBody );
		return PutRequestBody;

	}
	
	//ProgramBatchController-Post
		public static RequestSpecification PostCreateProgramBatch() {

			return requestSpec.setBasePath(LMSAPI_EndPoints.Create_New_Programbatch).build();

		}
		
		public static RequestSpecification PostCreateProgramBatch_InvalidEndpoint() {

			return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Create_New_ProgramBatch).build();

		}
		
		//PutBatchrequest
		
		public static String PutCreateProgramBatchRequest() {

				String PutRequestBatchBody = null;
				try {
					PutRequestBatchBody = FileUtils.readFileToString(new File(FileNameConstants.PutProgrambatchrequest),
							"UTF-8");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("PutRequestBody :" + PutRequestBatchBody );
				return PutRequestBatchBody;

			}
		
		public static RequestSpecification PutCreateProgramBatchID() {

			return requestSpec.setBasePath(LMSAPI_EndPoints.Update_Programbatch_By_batchID).build();

		}
		
		public static RequestSpecification InvalidPutCreateProgramBatchID() {

			return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_Programbatch_By_batchID).build();

		}
		//UserLogin Controller-Post Sign In
	    public static RequestSpecification PostUserSignIn() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.User_Sign_In).build();
	     
	    }
	    public static RequestSpecification InvalidPostUserSignIn() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_User_Sign_In).build();
	   	 
	    }   	 
	   //UserLogin Controller-Get LogOut
	     public static RequestSpecification GetUserLogOut() {
	     	 return requestSpec.setBasePath(LMSAPI_EndPoints.User_LogOut).build();
	      
	     }
	     public static RequestSpecification InvalidGetLogOut() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_User_LogOut).build();
	   //UserController-Post Create User  
	   }
	    public static RequestSpecification PostCreateUser() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Create_User).build();
	    }
	    public static RequestSpecification InvalidPostCreateUser() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Create_User).build();
	    }
	  //UserController-Update UserRole
	    public static RequestSpecification UpdateUserRole() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Update_UserRole).build();
	     
	    }
	    public static RequestSpecification InvalidUpdateUserRole() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_UserRole).build();
	    }
	  //UserController-Update UserRoleStatus
	    public static RequestSpecification UpdateUserRoleStatus() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Update_UserRoleStatus).build();
	     
	    }
	    public static RequestSpecification InvalidUpdateUserRoleStatus() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_UserRoleStatus).build();
	    }
	  //UserController-Update UserRoleProgramBatchStatus
	    public static RequestSpecification UpdateUserRoleProgramBatchStatus() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Update_UserRoleProgramBatchStatusStatus).build();
	     
	    }
	    public static RequestSpecification InvalidUpdateUserRoleProgramBatchStatus() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_UserRoleProgramBatchStatusStatus).build();
	    }
	  //UserController-Update UserLoginStatus
	    public static RequestSpecification UpdateUserLoginStatus() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Update_UserLoginStatus).build();
	     
	    }
	    public static RequestSpecification InvalidUpdateUserloginStatus() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_UserLoginStatus).build();
	    }
	  //UserController-Update UserInfo
	    public static RequestSpecification UpdateUserInfo() {
	    	 return requestSpec.setBasePath(LMSAPI_EndPoints.Update_UserInfo).build();
	     
	    }
	    public static RequestSpecification InvalidUpdateInfo() {
	   	 return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Update_UserInfo).build();
	    }
	  //UserController-Get All Roles)
	    public static RequestSpecification GetAllRoles() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Get_All_Roles).build();
	    }
	    public static RequestSpecification InvalidGetAllRoles() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_All_Roles).build();
	    }
	  //UserController-Get All Users)
	    public static RequestSpecification GetAllUsers() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Get_All_Users).build();
	    }
	    public static RequestSpecification InvalidGetAllUsers() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_All_Users).build();
	    }
	   //UserController-Get All Users)
	    public static RequestSpecification GetCount() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Get_count).build();
	    }
	    public static RequestSpecification InvalidGetCount() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_count).build();
	    }
	  //UserController-Get User by UserId)
	    public static RequestSpecification GetUSerbyUserID() {
	          return requestSpec.setBasePath(LMSAPI_EndPoints.Get_User_byUserID).build();
	      }
	    public static RequestSpecification InvalidGetUSerbyUserID() {
	          return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_User_byUserID).build();
	      }
	     //UserController-Get User by RoleId)
	     public static RequestSpecification GetUSerbyRoleID() {
	           return requestSpec.setBasePath(LMSAPI_EndPoints.Get_User_byroleID).build();
	       }
	     public static RequestSpecification InvalidGetUSerbyRoleID() {
	           return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_User_byroleID).build();
	       }
	     //UserController-Get AllUserswithroles)
	     public static RequestSpecification GetUSerwithRoles() {
	              return requestSpec.setBasePath(LMSAPI_EndPoints.Get_All_UserswithRoles).build();
	          }
	     public static RequestSpecification InvalidGetAllUserswithroles() {
	              return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_All_Userswithroles).build();
	          }
	   //UserController-Get All ActiveUsers)
	     public static RequestSpecification GetAllActiveUsers() {
	         return requestSpec.setBasePath(LMSAPI_EndPoints.Get_All_ActiveUsers).build();
	     }
	     public static RequestSpecification InvalidGetAllAvtiveUsers() {
	         return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_All_ActiveUsers).build();
	     }
	     //UserController-Get All UserswithFacets/Filters
	     public static RequestSpecification GetAllUsersWithFilters() {
	         return requestSpec.setBasePath(LMSAPI_EndPoints.Get_AllUsers_withFilters).build();
	     }
	     public static RequestSpecification InvalidGetAllUsersWithFilters() {
	         return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Get_AllUsers_withFilters).build();
	     }
	   	     
	   	//UserController-Delete /User
	    public static RequestSpecification DeleteUser() {
	        return requestSpec.setBasePath(LMSAPI_EndPoints.Delete_User).build();
	    }


	}
	

