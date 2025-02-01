package RestAssured_CRUD_Actions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_Delete_Method {
	@Test
	public void Test_Delete()
	{
		RestAssured.given().baseUri("https://reqres.in/api/users/116").
		when().delete().
		then().statusCode(204).log().all();
	}

}
