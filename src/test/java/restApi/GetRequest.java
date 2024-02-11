package restApi;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test() {

		RestAssured.baseURI= "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
	
	
	}

}
