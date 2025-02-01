package RestAssured_CRUD_Actions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PATCH_Method {
	@Test
	public void Test_Patch()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("Name", "Nitin");
		
		RestAssured.baseURI="https://reqres.in/api/users/116";
		RestAssured.given().header("Content-Type","application/JSON").contentType(ContentType.JSON).body(jsonData.toString()).
		when().patch().
		then().statusCode(200).log().all();
	}
}
