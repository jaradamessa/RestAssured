package restApi;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HashMapPost {
	@Test
	public void test1() {
		
		
		HashMap <String, String> obj= new HashMap<String, String>();
		obj.put("name", "Ashima");
		obj.put("Salary", "70000");
		obj.put("id", "2");
		
		RestAssured.baseURI= "http://localhost:3000/employees";
		RequestSpecification request= RestAssured.given();
		Response response = request.contentType(ContentType.JSON).body(obj).post();
		System.out.println("The respose code is " + response.getStatusCode());
		System.out.println("The response code is " + response.body().asString());	}

}
