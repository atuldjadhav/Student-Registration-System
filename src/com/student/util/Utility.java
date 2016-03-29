package com.student.util;


	
	import org.codehaus.jettison.json.JSONException;
	import org.codehaus.jettison.json.JSONObject;
	 
	public class Utility {
	    /**
	     * Null check Method
	     * 
	     * @param txt
	     * @return
	     */
	    public static boolean isNotNull(String txt) {
	        
	        return txt != null && txt.trim().length() >= 0 ? true : false;
	    }
	 
	    /**
	     * Method to construct JSON
	     * 
	     * @param tag
	     * @param status
	     * @return
	     */
	    public static String constructJSON(String tag, boolean status, int studentid) {
	        JSONObject obj = new JSONObject();
	        try {
	            obj.put("tag", tag);
	            obj.put("status", new Boolean(status));
	            obj.put("studentid", studentid);
	        } catch (JSONException e) {
	            
	        }
	        return obj.toString();
	    }
	 
	    /**
	     * Method to construct JSON with Error Msg
	     * 
	     * @param tag
	     * @param status
	     * @param err_msg
	     * @return
	     */
	    public static String constructJSON(String tag, boolean status,String err_msg) {
	        JSONObject obj = new JSONObject();
	        try {
	            obj.put("tag", tag);
	            obj.put("status", new Boolean(status));
	            obj.put("error_msg", err_msg);
	        } catch (JSONException e) {
	           
	        }
	        return obj.toString();
	    }
	 
	}


