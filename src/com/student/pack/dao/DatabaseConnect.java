package com.student.pack.dao;
import com.student.pack.rest.status.*;

import java.sql.*;

import org.codehaus.*;
import org.codehaus.jettison.json.JSONArray;

import com.student.util.*;

public class DatabaseConnect {
	
	String link1;
	
	public JSONArray queryReturnCoursename(String coursename) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where course.coursename= ?");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setString(1,coursename);
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      
	      
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	public JSONArray queryReturnCourseWithPrice(String price) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("SELECT course.coursecode, course.coursename,course.credits, section.sectionid,section.location,section.price,section.starttime"+ 
" from course left join section on section.coursecode=course.coursecode where section.price= ?");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setString(1,price);
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      
	      
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	





public JSONArray queryByTime(String starttime  ) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
	
	try {
		
		
		 String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      
		stmt = conn.prepareStatement("select coursecode, starttime from section where starttime=? ");
										
		
		
		
		// execute the query, and get a java resultset
	      
	      stmt.setString(1, starttime);
	      
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      json=conv.toJSONArray(rs);
	      
	      
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}


public JSONArray queryByLocation(String location  ) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
	
	try {
		
		
		 String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      
		stmt = conn.prepareStatement("select location from section " +
										"where location=? ");
		
		
		
		// execute the query, and get a java resultset
	      
	      stmt.setString(1, location);
	      
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      json=conv.toJSONArray(rs);
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}


public JSONArray queryBy4Parameters(String location ,String price,String starttime  ) throws Exception {
	
	PreparedStatement stmt = null;
	Connection conn = null;
	ConvertToJSON conv=new ConvertToJSON();
      JSONArray json=new JSONArray();
	
	try {
		
		
		 String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      
		stmt = conn.prepareStatement("select course.coursename,section.starttime,section.location,section.price from course left join section on section.coursecode=course.coursecode "+ " where location= ?"+" AND price= ?"+" AND starttime= ?" );
		System.out.println(stmt);
		JSONArray js=new JSONArray();
		
		// execute the query, and get a java resultset
	      
	     stmt.setString(1, location);
	     stmt.setString(2, price);
	     stmt.setString(3, starttime);
	      
	      
	      ResultSet rs = stmt.executeQuery();
	     
	      json=conv.toJSONArray(rs);
	      
	      
	  	rs.close();
	       
	      // iterate through the java resultset
	      
	      
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}


	
	/*public JSONArray queryReturnCourseWithPrice(String price) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("SELECT * FROM course where price= ?");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setString(1,price);
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      
	      
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	*/
	
	   
	  
	public JSONArray queryReturnNumberOfCourses(int studentid) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
	      
		Connection conn=null;
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("SELECT COUNT(studentid) FROM studentcourses where studentid=?");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setInt(1, studentid);;
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      
	      
	      json=conv.toJSONArray(rs);
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	
	public JSONArray queryCurrentCoursesEnrolled(int studentid) throws Exception{
		PreparedStatement stmt=null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		Connection conn=null;
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("SELECT * FROM studentcourses where studentid=?");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setInt(1, studentid);;
	      ResultSet rs = stmt.executeQuery();
	       
	      // iterate through the java resultset
	      
	      
	      
	      json=conv.toJSONArray(rs);
	      
	      
	      stmt.close();
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return json;
	}
	
	
	
	
	
	   
	  
	public int insertAddCourses(int studentid,int sectionid,String coursecode,String term,String grade ) throws Exception{
		PreparedStatement stmt=null;
		//ConvertToJSON conv=new ConvertToJSON();
	      //JSONArray json=new JSONArray();
		Connection conn=null;
		
		
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "root");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      stmt = conn.prepareStatement("insert into studentcourses(studentid,sectionid,coursecode,term,grade)values(?,?,?,?,?)");
	      
	 
	      
	       
	      
	       
	      // execute the query, and get a java resultset
	      stmt.setInt(1, studentid);
	      stmt.setInt(2, sectionid);
	      stmt.setString(3, coursecode);
	      stmt.setString(4, term);
	      stmt.setString(5, grade);
	      
	      stmt.executeUpdate();
	       
	      // iterate through the java resultset
	      
	      
	      
	      
	     
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return 500;
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	    return 200;
	}
	
	
public JSONArray dropCourses(int studentid, String coursecode) throws Exception {
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
		
		try {
			
			
			 String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/reg";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "root");
		       
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      
			stmt = conn.prepareStatement("delete from studentcourses " +
											"where studentid = ? AND coursecode = ? ");
			
			
			
			// execute the query, and get a java resultset
		      stmt.setInt(1, studentid);
		      stmt.setString(2, coursecode);
		      
		      stmt.executeUpdate();
		  
		      // iterate through the java resultset
		      
		      
		      
		      
		      stmt.close();
		     
		      
		    }catch(Exception e){
		    	e.printStackTrace();
		    	
		    }
		    finally{
		    	if(conn !=null) conn.close();
		    }
		    return json;
		}
	   
public static boolean loginCheck(String uname,String password) throws Exception{
	boolean userIsAvailable=false;
	Statement stmt = null;
	Connection conn = null;
	
	try{
		try{
			 String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost:3306/reg";
		      Class.forName(myDriver);
		      conn = DriverManager.getConnection(myUrl, "root", "root");
		}catch(Exception e){
			e.printStackTrace();
		}
		stmt=conn.createStatement();
		String query="Select * from login where username="+"'" + uname +"'AND password="+"'"+password +"'";
		System.out.println(query);
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			userIsAvailable=true;
			
		}
	} catch(SQLException sqle){
		throw sqle;
	}catch(Exception e){
		if(conn != null){
			conn.close();
		}
		throw e;
	} finally {
		if(conn !=null){
			conn.close();
		}
	}
	return userIsAvailable;
	
}


	



}
