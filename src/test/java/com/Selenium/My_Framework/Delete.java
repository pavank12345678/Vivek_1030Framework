package com.Selenium.My_Framework;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Delete {
	
	@Test
	public void jsonsimplee()
	{
	             when().
	                 delete("https://reqres.in/api/users/2").
	             then().
	                 statusCode(201).log().all();            
	            
	}
	
}    



