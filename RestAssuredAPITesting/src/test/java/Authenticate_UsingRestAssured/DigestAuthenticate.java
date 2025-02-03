package Authenticate_UsingRestAssured;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.Assert;
public class DigestAuthenticate {
	
	@Test
	public void DigestAuthenticate()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		
		ReqSpec.baseUri("http://httpbin.org/");
		ReqSpec.basePath("digest-auth/undefined/nitin/password");
		
		Response response = ReqSpec.auth().digest("nitin","password").get();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		System.out.println("StatusLine: "+response.statusLine());
		System.out.println("StatusCode: "+response.statusCode());
	}
}
