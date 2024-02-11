package apiXML;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XMLTest {

	@Test
	public void test1() {

RestAssured.baseURI = "https://chercher.tech/sample/api/books.xml";
		
		RequestSpecification  request = RestAssured.given();
			
		Response response = request.get();
		
		System.out.println("Response is " + response.body().asString());
		
		NodeChildrenImpl store = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All the books are " + store.toString());
		System.out.println("First book is " + store.get(0));
		System.out.println("Second book is " + store.get(1));

	}

}
