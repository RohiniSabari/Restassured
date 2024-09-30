package utils;


import java.io.File;
import java.util.HashMap;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import testdata.updateuser;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class Restutils {
	public static Response taPost(String endpoint, HashMap<String, String> headers,Object payload) {
		
		Response res = RestAssured.given().headers(headers).when().body(payload).post(endpoint);
		return res;
	}

	public static Response taPost(String endpoint, HashMap<String, String> header, String payload) {

	
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).post(endpoint);
		return res;
	}
	

	public static Response taGet(String sBaseUri, HashMap<String, String> header) {
		RestAssured.baseURI = sBaseUri;
		Response res = RestAssured.given().headers(header).when().get();
		return res;
	}

	public static Response taPut(String endpoint, HashMap<String, String> header, updateuser user1) {
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(user1).put(endpoint);
		return res;
	}
	
	public static Response taDelete(String endpoint, HashMap<String, String> header,String payload) {
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).delete(endpoint);
		return res;
	}
	public static void validateschema(Response actualres,String schemafilepath) {
		actualres.then().assertThat().body(matchesJsonSchema(new File(schemafilepath)));
	}

}
