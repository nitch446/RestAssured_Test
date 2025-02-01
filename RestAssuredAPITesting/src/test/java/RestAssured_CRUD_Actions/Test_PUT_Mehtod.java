package RestAssured_CRUD_Actions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PUT_Mehtod {
	@Test
	public void Test_Put()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("Name", "kshitiz");
		
		RestAssured.baseURI="https://reqres.in/api/users/116";
		RestAssured.given().header("Content-Type","application/JSON").contentType(ContentType.JSON).body(jsonData.toString()).
		when().put().
		then().statusCode(200).log().all();
	}

}
