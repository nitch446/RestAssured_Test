package RestAssured_ValidateHeader;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
public class ValidateHeader {
	@Test
	public void validateHeader()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		ReqSpec.baseUri("https://reqres.in/");
		ReqSpec.basePath("/api/users/2");
		
		Response response = ReqSpec.get();
		String ContentType = response.getHeader("Content-Type");
		System.out.println("ContentType : "+ ContentType);
		
		Assert.assertEquals(ContentType,"application/json; charset=utf-8","Incorrect ContentType");
	}

}
