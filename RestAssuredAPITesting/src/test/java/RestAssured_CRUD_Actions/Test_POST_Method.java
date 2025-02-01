package RestAssured_CRUD_Actions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_POST_Method {
	
	@Test
	public void TestPOST()
	{
		JSONObject JSONData = new JSONObject();
		JSONData.put("Name", "Nitin");
		JSONData.put("Job", "QA");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(JSONData.toJSONString()).
		when().post().
		then().statusCode(201).log().all();

		
	}

}
