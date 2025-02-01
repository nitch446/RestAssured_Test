package RestAssured_CRUD_Actions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_Get_Method {
	@Test
	public void TestGet()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("ResponseCode: "+res.getStatusCode());
		System.out.println("Response Body: "+res.getBody().asString());
		System.out.println("Response Time: "+res.getTime());
		System.out.println("Response Header: "+res.getHeader("Content-Type"));
		
		// Validation
		
		int ExpectedStatusCode = 200;
		int ActualStatusCode = res.getStatusCode();
		Assert.assertEquals(ExpectedStatusCode, ActualStatusCode);
		
	}
	
	// RestAssured support BDD styles as well
	// No need to use class "RestAssured" again and again
	// just make import static io.restassured.RestAssured.*; => And Directly use function and variables
	@Test
	public void BDD_Style()
	{
		// RestAssured.baseURI = "https://reqres.in/api/users";
		// RestAssured.given().queryParam("page","2").when().get().then().statusCode(200);
	
		RestAssured.given().baseUri("https://reqres.in/api/users/116").
		when().get().
		then().statusCode(404).log().all();
	
	}
	

	
	

}
