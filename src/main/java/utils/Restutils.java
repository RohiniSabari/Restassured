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
	

	public static Response taGet(String endpoint, HashMap<String, String> header) {
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		//RestAssured.baseURI = sBaseUri;
		Response res = RestAssured.given().headers(header).when().get(endpoint);
		return res;
	}

	public static Response taPut(String endpoint, HashMap<String, String> header, String payload) {
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).put(endpoint);
		return res;
	}
	
	public static Response taDelete(String endpoint, HashMap<String, String> header,String payload) {
		System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).delete(endpoint);
		return res;
	}
	
	
public static Response logoutPost(String endpoint, HashMap<String, String> headers) {
	System.out.println("taPost: URI :" + RestAssured.baseURI+endpoint);
	RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(headers).when().post(endpoint);
		return res;
	}
	
	
	
	public static void validateschema(Response actualres,String schemafilepath) {
		actualres.then().assertThat().body(matchesJsonSchema(new File(schemafilepath)));
	}

}
