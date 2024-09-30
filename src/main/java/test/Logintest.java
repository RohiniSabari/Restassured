package test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import Constants.FileConstant1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import testdata.Adduser;
import testdata.DeserializableExample;
import testdata.updateuser;
import utils.Datautils;

import utils.Restutils;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Logintest extends Basetest{
	//@Test
	public void login() throws IOException {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		String env = Datautils.readJsonFileToString(FileConstant1.ENV_URI_FILE_PATH);
		String envUri = JsonPath.read(env, "$.prod.uri") ;
		String endpoint = JsonPath.read(env, "$.prod.endpoint.login");
		String creds = Datautils.readJsonFileToString(FileConstant1.USERACCOUNTS_TD_FILE_PATH);
		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("username", JsonPath.read(creds, "$.prod.valid.username"));
		credentials.put("password", JsonPath.read(creds, "$.prod.valid.password"));
	
	
		Response res = Restutils.taPost(envUri+endpoint, headers, credentials);
		//Assert.assertEquals(res.getStatusCode(),201);
		Restutils.validateschema(res,FileConstant1.loginschema_FILE_PATH);
		System.out.println(res.prettyPrint());
	
	
		
	}
	
	//@Test
	public void invalidlogin1() throws IOException {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		String env = Datautils.readJsonFileToString(FileConstant1.ENV_URI_FILE_PATH);
		String envUri = JsonPath.read(env, "$.prod.uri") ;
		String endpoint = JsonPath.read(env, "$.prod.endpoint.login");
	
		String creds = Datautils.readJsonFileToString(FileConstant1.USERACCOUNTS_TD_FILE_PATH);
		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("username", JsonPath.read(creds, "$.prod.invalid.username"));
		credentials.put("password", JsonPath.read(creds, "$.prod.invalid.password"));
	
	
		Response res = Restutils.taPost(envUri+endpoint, headers, credentials);
		Assert.assertEquals(res.getStatusCode(),401);
		
		System.out.println(res.prettyPrint());
	}

	
	
	//@Test
	public void getdata() throws IOException {
		ObjectMapper om = new ObjectMapper();
		String endPoint = Datautils.gettestdata(FileConstant1.ENV_URI_FILE_PATH, "$.prod.endpoint.getdata");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", generatetoken());
		Response res = Restutils.taGet(RestAssured.baseURI + endPoint, headers);
		String getUser1 = om.writeValueAsString(res.jsonPath().get("[1]"));
DeserializableExample ds = om.readValue(getUser1, DeserializableExample.class);
		System.out.println(getUser1);
		res.then().assertThat().statusCode(200);
		assertThat("Expecting 200", 200 == res.getStatusCode());
}
	
	
	
//	@Test
	public void addUser_TC02() throws IOException {
		Adduser user1 = new Adduser("TA-1234568", "1", "2" , "111116"); 
		//RestAssured.baseURI = Datautils.gettestdata(FileConstant1.ENV_URI_FILE_PATH, "$.prod.uri").toString();;
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.PUBLIC_ONLY);
		String payload = om.writeValueAsString(user1);
		String env = Datautils.readJsonFileToString(FileConstant1.ENV_URI_FILE_PATH);
		String endpoint = JsonPath.read(env, "$.prod.endpoint.adddata");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", generatetoken());
		Response res = Restutils.taPost(RestAssured.baseURI+endpoint, headers, user1);
		
		res.then().assertThat().statusCode(200);
	}

	
	
	//@Test
	public void updatedata(){
		try {
		//RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
			updateuser user1 = new updateuser("TA-1234569", "2", "2" , "111116"); 
			ObjectMapper om = new ObjectMapper();
			om.setVisibility(PropertyAccessor.FIELD, Visibility.PUBLIC_ONLY);
			String payload = om.writeValueAsString(user1);
			String env = Datautils.readJsonFileToString(FileConstant1.ENV_URI_FILE_PATH);
			String endpoint = JsonPath.read(env, "$.prod.endpoint.updatedata");
			
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			headers.put("token", generatetoken());
			Response res = Restutils.taPut(RestAssured.baseURI+endpoint, headers, user1);
			
			res.then().assertThat().statusCode(401);
		}
		catch (Exception e) {
	       
	        e.printStackTrace();
	    }
		
	}
	@Test
	public void delete() throws IOException {
		updateuser user1 = new updateuser("TA-1234569", "2", "2" , "111116"); 
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.PUBLIC_ONLY);
		String payload = om.writeValueAsString(user1);
		String env = Datautils.readJsonFileToString(FileConstant1.ENV_URI_FILE_PATH);
		//String creds = Datautils.readJsonFileToString(FileConstant1.USER_TD_FILE_PATH);
		String endpoint = JsonPath.read(env, "$.prod.endpoint.deletedata");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", generatetoken());
		Response res = Restutils.taDelete(RestAssured.baseURI+endpoint, headers,payload);
		
		res.then().assertThat().statusCode(401);
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

