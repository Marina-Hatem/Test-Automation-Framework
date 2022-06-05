package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

class UsingRESTassured 
{
	
	@Test
	public void TestWithRESTAssured1()
	{
		
		Response response = get("https://reqres.in/api/users?page=1");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void TestGETWithRESTAssured()
	{
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("Michael", "Tobias"));
		
	}
	
	@Test
	public void TestPOSTWithRESTAssured()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Marina");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).
		when().post("/users").
		then().statusCode(201).
			log().all();
	}
	
	@Test
	public void TestPUTWithRESTAssured()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Marina");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).
		when().put("/users/2").
		then().statusCode(200).
			log().all();
	}
	
	
	@Test
	public void TestPATCHWithRESTAssured()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Marina");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).
		when().patch("/api/users/2").
		then().statusCode(200).
			log().all();
	}
	
	@Test
	public void TestDELETEWithRESTAssured()
	{
		
		baseURI = "https://reqres.in/api";
		
		
		when().delete("/api/users/2").
		then().statusCode(204).
			log().all();
	}

}
