package com.Selenium.My_Framework;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class RestPostSample {

	@Test
	public void jsonsimple()
	{
		JSONObject request= new JSONObject();
				request.put("name", "pavan");
	            request.put("job", "pavann");
	            System.out.println(request);
	            given().
	            header("Content-Type", "application/jsaon").
	            contentType(ContentType.JSON).accept(ContentType.JSON).
	                 body(request.toJSONString()).
	             when().
	                 post("https://reqres.in/api/users").
	             then().
	                 statusCode(201);                 
	            
	}
	
}    
