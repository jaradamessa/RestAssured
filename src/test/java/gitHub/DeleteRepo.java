package gitHub;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {

	@Test
	public void test1() {

		RestAssured.baseURI = "https://api.github.com/repos/jaradamessa/RestAssuredRepo";

		RequestSpecification request = RestAssured.given();

		Response response = request.auth().oauth2("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").delete();

		System.out.println("The Response body is " + response.body().asString());

	}

}
