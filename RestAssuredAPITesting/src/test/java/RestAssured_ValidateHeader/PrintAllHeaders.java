package RestAssured_ValidateHeader;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PrintAllHeaders {
	@Test
	public void ValidateAllHeaders()
	{
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://reqres.in/");
		reqspec.basePath("/api/users/2");
		
		Response response = reqspec.get();
		Headers headerslist = response.getHeaders();
		
		for(Header header : headerslist )
		{
			System.out.println("Key: "+header.getName()+" Value: "+header.getValue());
		}
		
	}

}
