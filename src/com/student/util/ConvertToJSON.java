package com.student.util;

import java.sql.ResultSet;

import org.codehaus.jettison.json.*;
import com.student.pack.rest.status.*;

public class ConvertToJSON {
	
	
	
	


	public JSONArray toJSONArray(ResultSet rs) throws Exception {
		
		JSONArray json=new JSONArray();
		
		
		try{
		java.sql.ResultSetMetaData rsmd=rs.getMetaData();
		
		while(rs.next()){
			int numcol=rsmd.getColumnCount();
			JSONObject obj = new JSONObject();
			
			for(int i=1;i<numcol+1;i++){
				String col_name=rsmd.getColumnName(i);
				
				if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
					obj.put(col_name, rs.getArray(col_name));
					//System.out.println("ToJSON: ARRAY");
				}
				else if (rsmd.getColumnType(i)==java.sql.Types.INTEGER){
					obj.put(col_name, rs.getInt(col_name));
					//System.out.println("ToJSON: BIGINT");
				}
				else if (rsmd.getColumnType(i)==java.sql.Types.BIGINT){
					obj.put(col_name, rs.getInt(col_name));
					//System.out.println("ToJSON: BIGINT");
				}
				else if (rsmd.getColumnType(i)==java.sql.Types.DATE){
					obj.put(col_name, rs.getDate(col_name));
					//System.out.println("ToJSON: DATE");
				}
				else if (rsmd.getColumnType(i)==java.sql.Types.FLOAT){
					obj.put(col_name, rs.getFloat(col_name));
					//System.out.println("ToJSON: FLOAT");
				}
				else if (rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
					obj.put(col_name, rs.getString(col_name));
					//System.out.println("ToJSON: VARCHAR");
				}
				else{
					obj.put(col_name, rs.getObject(col_name));
					//System.out.println("ToJSON: Object"+col_name);
				}
				
			}
			json.put(obj);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return json;
			
	}
	

}
