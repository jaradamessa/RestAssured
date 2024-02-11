package gitHub;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllRepo {
	
	@Test
	public void gitHub() {
		
		RestAssured.baseURI= "https://api.github.com/users/jaradamessa/repos";

		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println("All the reopis are "+ response.body().asString());
		
	}

}
