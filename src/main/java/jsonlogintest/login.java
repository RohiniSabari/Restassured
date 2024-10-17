package jsonlogintest;


	

	import java.util.HashMap;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.google.gson.JsonObject;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;

	public class login {
		

		@Test
		public void login1() {
			RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
			
			HashMap<String, String> payloadLogin = new HashMap<String, String>();
			payloadLogin.put("username", "july2024.rohini@tekarch.com");
			payloadLogin.put("password", "Admin123");
			
			
			JsonObject jsonObjLogin = new JsonObject();
			jsonObjLogin.addProperty("username", "july2024.rohini@tekarch.com");
			jsonObjLogin.addProperty("password", "Admin123");
			
			Response res =  RestAssured.given().contentType(ContentType.JSON).when()
			.body(payloadLogin)
			.post("/login");

			
			Assert.assertEquals(res.getStatusCode(), 201);
			System.out.println(res.prettyPrint());
			
			String token = res.jsonPath().getString("token").replace("[", "").replace("]", "");
			System.out.println(token);
			
			Response res1 =  RestAssured.given().contentType(ContentType.JSON)
					.header("token", token).when()
					.get("/getdata");
			System.out.println(res1.getStatusCode());
			System.out.println(res1.prettyPrint());
			
			
			Response res2 =  RestAssured.given().contentType(ContentType.JSON)
					.header("token", token).when()
					.body("{\"accountno\": \"TA-5678333\", \"departmentno\": \"4\", \"salary\": \"45678\", \"pincode\": \"234567\"}")
					.post("/addData");
			System.out.println(res.statusCode());
			System.out.println(res2.prettyPrint());
		}
	}


