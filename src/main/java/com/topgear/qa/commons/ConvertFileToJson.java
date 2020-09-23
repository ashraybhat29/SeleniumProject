package com.topgear.qa.commons;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ConvertFileToJson {

    
	public static  String convertFileToJsonObject(){
        String body=null;
        JsonElement element=null;
        try{
            JsonParser parser=new JsonParser();
             element=parser.parse(new FileReader(System.getProperty("user.dir")+""));
            body=((JsonObject) element).get("signin").toString();
        }
        catch (Exception e)
        {

        }

        return body;
    }
    
  /*  public static String register (String firstname,String lastname,String password) {
    	JsonObject obj =new JsonObject();
    	String filename = null;
		convertFileToJsonObject(filename);
		 firstname= obj.get("firstname").getAsString();
    	 lastname= obj.get("lastname").getAsString();
    	  password= obj.get("password").getAsString();
    	  return(firstname,lastname,password);
    }
*/}