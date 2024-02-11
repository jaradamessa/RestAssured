package restAPIBDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestApiTest {
	String baseURI = "http://localhost:3000/employees";

	@Test
	public void getOperation() {

		RestAssured.given().baseUri(baseURI)
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
	}

	@Test
	public void getOperationParam() {
		RestAssured.given().baseUri(baseURI).when().get("/7")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("name",Matchers.equalTo("Jara"));

	}
	
	@Test
	public void getQueryParam() {
		RestAssured.given()
		.queryParam("CUSTOMER_ID", "68195")
		.queryParam("PASSWORD", "1234!")
		.queryParam("Account_No", "1")
		.baseUri("https://demo.guru99.com/V4/sinkministatement.php")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	@Test
	public void postHashMapParam() {
		HashMap <String, String> obj = new HashMap <String, String>();
		obj.put("name", "John");
		obj.put("salary", "9000");
		obj.put("id", "10");

		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
		.baseUri(baseURI)
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200);
	}

}
