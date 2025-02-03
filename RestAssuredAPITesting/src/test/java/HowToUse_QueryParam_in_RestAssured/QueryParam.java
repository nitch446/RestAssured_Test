package HowToUse_QueryParam_in_RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;

//https://reqres.in/api/users?page=2

public class QueryParam {
	@Test
	public void QueryParam()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		ReqSpec.baseUri("https://reqres.in");
		ReqSpec.basePath("/api/users");
		ReqSpec.queryParam("page",2).queryParam("id",9);
		
		Response response = ReqSpec.get();
		String ResponseBody = response.getBody().asString();
		
		System.out.println("ResponseBody: "+ResponseBody);
		
		JsonPath JsonPathView = response.jsonPath();
		String FirstName = JsonPathView.get("data.first_name");
		
		Assert.assertEquals(FirstName, "Tobias","Incorrect Match!! ");
	}

}
