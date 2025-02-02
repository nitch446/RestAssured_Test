package RestAssured_ResponseValidation;
import org.testng.Assert;
import io.restassured.response.Validatable;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ValidateResponse_Using_RequestSpecification {
	@Test(enabled = false)
	public void Test_ResponseStatus_Using_RequestSpecification()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification ReqSpec = RestAssured.given();
		
		Response response = ReqSpec.get();
		
		int Actualstatuscode = response.getStatusCode();
		
		Assert.assertEquals(Actualstatuscode, 200,"InCorrect StatusCode Received");
		
		String statusline = response.statusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK","Incorrect Statusine Received");
		
	}
	
	@Test
	public static void bdd_Check_StatusLine()
	{
		given()
				.baseUri("https://reqres.in/api/users/2")
		.when()
				.get()
		.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
		
	}
	

}
