package com.Selenium.My_Framework;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Restsameput {
	@Test
	public void jsonsimplepp()
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
	                 put("https://reqres.in/api/users/2").
	             then().
	                 statusCode(200).log().all();            
	            
	}
	
}    



