package com.student.pack.rest.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.student.pack.dao.DatabaseConnect;
import com.student.util.Utility;




	
	@Path("/login")
	public class Login {
	    // HTTP Get Method
	    @GET
	    // Path: http://localhost/<appln-folder-name>/login/dologin
	    @Path("/dologin")
	    // Produces JSON as response
	    @Produces(MediaType.APPLICATION_JSON) 
	    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
	    public String doLogin(@QueryParam("username") String uname, @QueryParam("password") String password){
	        String response = "";
	        int studentid=Login.getStudentID(uname);
	        if(checkCredentials(uname, password)){
	            response = Utility.constructJSON("login",true,studentid);
	        }else{
	            response = Utility.constructJSON("login", false, "Incorrect username or Password");
	        }
	    return response;        
	    }
	 
	    /**
	     * Method to check whether the entered credential is valid
	     * 
	     * @param uname
	     * @param pwd
	     * @return
	     */
	    private boolean checkCredentials(String uname, String password){
	        System.out.println("Inside checkCredentials");
	        boolean result = false;
	        if(Utility.isNotNull(uname) && Utility.isNotNull(password)){
	            try {
	                result = DatabaseConnect.loginCheck(uname, password);
	                //System.out.println("Inside checkCredentials try "+result);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                //System.out.println("Inside checkCredentials catch");
	                result = false;
	            }
	        }else{
	            //System.out.println("Inside checkCredentials else");
	            result = false;
	        }
	 
	        return result;
	    }
	    private static int getStudentID(String uname){
	    	Connection conn=null;
	    	PreparedStatement stmt=null;
	    	int id=0;
	    	try{
	    	String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/reg";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "root");
		      stmt = conn.prepareStatement("SELECT StudentID from login where username=?");
		   
		    		  	      // execute the query, and get a java resultset
		    		  	      stmt.setString(1,uname);
		    		  	      ResultSet rs = stmt.executeQuery();
		    		  	      while(rs.next()){
		    		  	    	  id=rs.getInt("Studentid");
		    		  	    	  
		    		  	      }
		    		  	      
	    	}
	    	catch(Exception e){
	    		System.out.println(e);
	    	}
	    	return id;
	    }
	 
	}

