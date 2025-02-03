package Authenticate_UsingRestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import io.restassured.http.ContentType;

public class BearerToken {
	@Test
	public void BearerToken()
	{
		RequestSpecification ReqSpec = RestAssured.given();
		ReqSpec.baseUri("https://gorest.co.in");
		ReqSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		
		payload.put("name","nitin chauhan");
		payload.put("gender","male");
		payload.put("email","abc12843@gmail.com");
		payload.put("status","active");
		
		String AuthToken = "Bearer 672bd642cb7f64d1741210d69ac73f45897181bb467ef679b8fff0d5cdb9fe00";
		
		ReqSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toJSONString());
		
		Response response = ReqSpec.post();
		
		Assert.assertEquals(response.statusCode(),201);
		
		System.out.println("Response Line: "+response.statusLine());
		System.out.println("Response Body: "+response.getBody().asString());
	}
	
}
