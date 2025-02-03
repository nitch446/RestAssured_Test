package Authenticate_UsingRestAssured;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuthenticate {
	@Test
	public void BasicAuthenticate()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		ReqSpec.baseUri("http://postman-echo.com");
		ReqSpec.basePath("/basic-auth");
		
		// PreEmptive => Credential provided in advance with request 
		// Non-Preemptive => Credential provided later when asked (Basic)
		Response response = ReqSpec.auth().basic("postman","postman").get();
		
		System.out.println("Status Line: "+ response.statusLine());
		
	}

}
