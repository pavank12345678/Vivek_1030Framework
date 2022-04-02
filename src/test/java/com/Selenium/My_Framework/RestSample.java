package com.Selenium.My_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RestSample {

	@Test()
	public void pathParamTest() {
	//Response Response=RestAssured.get("https://reqres.in/api/users?page=2");
		Response Response=get("https://reqres.in/api/users?page=2");
    Response.getStatusCode();
	Response.getBody();
	Response.asString();
	
	System.out.println(Response.getStatusCode());
	System.out.println(Response.getStatusLine());
	System.out.println(Response.getContentType());
	System.out.println(Response.asString());
	System.out.println(Response.getBody().asString());
	System.out.println(Response.getHeader("content-type"));
	
	int statuscode=Response.getStatusCode();
	Assert.assertEquals(statuscode, 201);

	}
	
	@Test
	public void pathParamTest2() 
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(201)
		//.body("data.id[0]", equalTo(7));
		.body("data.id", hasItems(7, 9));
	}
	
	
}

//RestAssured.authentication=RestAssured.given().auth().preemtive().basic("ToolsQA","Password")

