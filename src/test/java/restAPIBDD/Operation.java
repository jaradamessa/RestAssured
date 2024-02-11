package restAPIBDD;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Operation {
	String BaseURI = "http://localhost:3000/employees";
	
	@Test
	public void POST_BDDDemo() throws IOException {

		byte[] file = Files.readAllBytes(Paths.get("dataOp.json"));
		RestAssured.baseURI = BaseURI;
		RestAssured.given()
																	.contentType(ContentType.JSON)
																	.accept(ContentType.JSON)
																	.body(file)
																	.post();
		
		
	
	}

	@Test
	public void Delete_BDDDemo() {
		
		RestAssured.given().baseUri(BaseURI)
		.contentType(ContentType.JSON)
        .when()
        .delete("/12")
        .then()
        .assertThat().statusCode(200)
		.body("name", Matchers.equalTo("Boss"));

	}


}
