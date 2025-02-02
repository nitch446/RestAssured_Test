package ValidateJSONResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ValidateJSON_ContainString {
	@Test
	public void JSON_ContainString()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		ReqSpec.baseUri("https://reqres.in/");
		ReqSpec.basePath("api/users?page=2");
		
		Response response = ReqSpec.get();
		
		ResponseBody responsebody = response.getBody();
		
		String JSONString = responsebody.asString();
		
		System.out.println("JSON Sting: "+ JSONString);
		
	//	Assert.assertEquals(JSONString.contains("Bluth"),true);
		
		JsonPath jsonpathview = responsebody.jsonPath(); 
		
		String LastName = jsonpathview.get("data[3].last_name");
		
		Assert.assertEquals(LastName,"Holt");
		
	}
}
