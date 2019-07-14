package org.ssfdc.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.testng.annotations.Test;


public class ApiResponseTest {
		
	String accessToken=null;
	String devId,devName,srlNo=null;
	
	
	
	@Test
	public void extractingNamesAPI()
	{
		//BaseURL or Host
	
		RestAssured.baseURI="https://test.salesforce.com";
		rawToJson();
		String accessToken=getAccessToken();
		System.out.println(accessToken);
		
		/*JsonPath jsAccResult=rawToJsonAccountResp();
		String name= jsAccResult.getString("recentItems[0].Name");
		System.out.println("Account name is...."+name);*/
		getAcctName();
		JsonPath jsDevResult=rawToJsonDeviceResp();
		devId= jsDevResult.getString("recentItems[0].Id");		
		
		devName= jsDevResult.getString("recentItems[0].Name");
		
		JsonPath jsDevSerResult=rawToJsonDeviceSerial();
		srlNo=jsDevSerResult.getJsonObject("Serial_Number__c");
		System.out.println("Device name is ..."+devName+" DeviceId is .."+devId+" Serial no is..."+srlNo);

	}
	
	public String getAcctName(){
		JsonPath jsAccResult=rawToJsonAccountResp();
		String acctname= jsAccResult.getString("recentItems[0].Name");
		//System.out.println("Account name is...."+acctname);
		return acctname;
		
	}
		   
	public JsonPath rawToJson()
	{ 
		Response res=given().urlEncodingEnabled(true).header("Accept", ContentType.JSON.getAcceptHeader())		
		        .param("username", "nvallab1@its.jnj.com.test")
		        .param("password", "Testing@123")
		        .param("grant_type", "password")
		        .param("client_id", "3MVG99qusVZJwhslot1d9cvwBzthOSUUg0Fr8G8lcltCpM2fsBi5n.xJo0cTEnxAaEgO7lzrkeq3bNa24sr8N")
		        .param("client_secret", "271244905607018430")
		        .when()
		        .post("/services/oauth2/token")
		        .then().extract().response();
	    
		
		String resp=res.asString();
		JsonPath jspath=new JsonPath(resp);
		return jspath;
	}
	
	
	public  JsonPath rawToJsonAccountResp()
	{ 
		System.out.println("accessToken.........."+accessToken);
		Response accRes=given().
				header("Authorization","Bearer "+ accessToken)
						.when().get(getInstanceURL()+"/services/data/v46.0/sobjects/Account").then().extract().response();
		
		String resp=accRes.asString();
		//System.out.println("Account response.........."+resp);
		
		JsonPath jspath=new JsonPath(resp);
		return jspath;
	}
	
	public JsonPath rawToJsonDeviceResp()
	{ 
		//System.out.println("accessToken.........."+accessToken);
		Response deviceRes=given().
				header("Authorization","Bearer "+ accessToken)
						.when().get(getInstanceURL()+"/services/data/v46.0/sobjects/Device__c").then().extract().response();
		
		String resp=deviceRes.asString();
		//System.out.println("Device response.........."+resp);
		
		JsonPath jspath=new JsonPath(resp);
		return jspath;
	}
	
	
		
	public JsonPath rawToJsonDeviceSerial()
	{ 
		
		Response deviceRes=given().
				header("Authorization","Bearer "+ accessToken)
						.when().get(getInstanceURL()+"/services/data/v46.0/sobjects/Device__c/"+devId).then().extract().response();
		
		String resp=deviceRes.asString();
		//System.out.println("Device response.........."+resp);
		
		JsonPath jspath=new JsonPath(resp);
		return jspath;
	}
	
	public String getAccessToken()
	{
		accessToken= rawToJson().get("access_token");
		return accessToken;
	}

	public String getInstanceURL()
	{
		String instanceUrl=rawToJson().get("instance_url");
		return instanceUrl;
	}
	


	/*public String getAcctName()
	{
		JsonPath jsAccResult=reuse.rawToJsonAccountResp();
		acctname= jsAccResult.getString("recentItems[0].Name");
		System.out.println("Account name is...."+acctname);
		return acctname;
	}*/
	
	}



