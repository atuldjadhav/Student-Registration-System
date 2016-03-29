package com.student.pack.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.sql.*;

import com.student.util.ConvertToJSON;
import com.student.pack.dao.*;

@Path("/studentrest/status")
public class Student_reststatus {
      @GET
	  @Produces(MediaType.TEXT_HTML)
	 public String returnTitle(){
	 return "<p> Student Web Service</p> ";
	}
	
	
	
	@Path("/studentrecords")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	 public String studentRecords() throws Exception {
	  
		Statement stmt=null;
		String returnString=null;
		Connection conn=null;
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/reg";
	      Class.forName(myDriver);
	      conn = DriverManager.getConnection(myUrl, "root", "sagar@123");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM student";
	 
	      // create the java statement
	       stmt = conn.createStatement();
	       
	      // execute the query, and get a java resultset
	      ResultSet rs = stmt.executeQuery(query);
	       
	      // iterate through the java resultset
	      
	      ConvertToJSON conv=new ConvertToJSON();
	      JSONArray json=new JSONArray();
	      json=conv.toJSONArray(rs);
	      
	      returnString=json.toString();
	      
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	    finally{
	    	if(conn !=null) conn.close();
	    }
	     return returnString; 
	      
	      
	      
	    }
	
	
	
	@Path("/findcourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByName(@QueryParam("coursename") String coursename) throws Exception{
		
		
		String returnString=null;
		String message=null;
		
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryReturnCoursename(coursename);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }
	@Path("/findprice")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByPrice(@QueryParam("price") String price) throws Exception{
		
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryReturnCourseWithPrice(price);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }
	
	@Path("/findtime")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByTime(@QueryParam("bytime") String bytime) throws Exception{
		
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryByTime(bytime);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }
	
	@Path("/findlocation")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByLocation(@QueryParam("bylocation") String bylocation) throws Exception{
		
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryByLocation(bylocation);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }
	
	@Path("/findbyfields")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByAll(@QueryParam("bylocation") String bylocation,@QueryParam("byprice") String byprice,@QueryParam("bystarttime") String bystarttime) throws Exception{
		
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryBy4Parameters(bylocation,byprice,bystarttime);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }
	
	
	/*@Path("/findprice")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCourseByPrice(@QueryParam("price") String price) throws Exception{
		
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		
		
	    try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryReturnCourseWithPrice(price);
	      returnString=json.toString();
	      
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
	      
	      
	    }*/
	
	@Path("/checklimitcourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLimitOfCoursesforStudent(@QueryParam("studentid")int studentid)throws Exception{
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryReturnNumberOfCourses(studentid);
	      returnString=json.toString();
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
		
		
		
		
	}
	
	@Path("/checkcourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkCoursesforStudent(@QueryParam("studentid")int studentid, @Context UriInfo uriInfo )throws Exception{
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		
		
		try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.queryCurrentCoursesEnrolled(studentid);
	     // returnString=json.toString() + link1;
	      returnString=json.toString();
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
		
		
		
		
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(String indata)throws Exception{
		
		String returnString=null;
		JSONArray jsonArray=new JSONArray();
		
		DatabaseConnect dao=new DatabaseConnect();
		
		
		
		try
	    {
	      System.out.println("incomingdata: " + indata);
			ObjectMapper mapper=new ObjectMapper();
			AddCourse addcourse=mapper.readValue(indata,AddCourse.class);
			
			int http_code=dao.insertAddCourses(addcourse.studentid, addcourse.sectionid, addcourse.coursecode, addcourse.term, addcourse.grade);
			
			if(http_code==200){
				returnString="Course Added";
			}else{
				return Response.status(500).entity("Unable to add course").build();
			}
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
		
		
		
		
	}
	
	
	@Path("/dropcourses")
	@GET
	
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response dropCourses(@QueryParam("studentid")int studentid,
			@QueryParam ("coursecode")String coursecode)throws Exception{
		
		String returnString=null;
		JSONArray json=new JSONArray();
		
		try
	    {
	      
	      DatabaseConnect dao=new DatabaseConnect();
	      json=dao.dropCourses(studentid, coursecode);
	      returnString="Course Drop Successfully";
	      
	    }catch(Exception e){
	    	e.printStackTrace();
	    	return Response.status(500).entity("Server cannot able to process request").build();
	    	
	    }
	    
	     return Response.ok(returnString).build(); 
	      
		
		
		
		
	}
		
	}


class AddCourse{
	public int studentid;
	public int sectionid;
	public String coursecode;
	public String term;
	public String grade;
	
	
}
	      
	      
	      
	     


	    



