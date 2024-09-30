package test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeTest;

import com.jayway.jsonpath.JsonPath;

import Constants.FileConstant1;
import constants.FileConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import utils.Datautils;

import utils.Restutils;

public class Basetest {
	
	
	static String token = null;

	@BeforeTest
	public void setup() throws IOException {
		RestAssured.baseURI = Datautils.gettestdata(FileConstant1.ENV_URI_FILE_PATH, "$.prod.uri").toString();;
	}

public static String generatetoken() throws IOException {
	
	//Object payload=Datautils.gettestdata(FileConstant1.USERACCOUNTS_TD_FILE_PATH,"$.prod.valid");
	String payload= "{\"username\": \"july2024.rohini@tekarch.com\",\"password\": \"Admin123\"}";
	HashMap<String, String> headers = new HashMap<String, String>();
	headers.put("Content-Type", "application/json");
	String uri=RestAssured.baseURI;
	String endpoint = Datautils.gettestdata(FileConstant1.ENV_URI_FILE_PATH, "$.prod.endpoint.login").toString();

	
	
	if(token==null) {

	Response loginres = Restutils.taPost(uri+endpoint,headers,payload);
	//Restutils.validateschema(loginres,FileConstant1.getdataschema_FILE_PATH);
	//System.out.println(loginres.asString());
	token = loginres.jsonPath().get("[1].token");
	}else {
		System.out.println("Token is already generated");
	}
	return token;
	}
}





