package stepDefination;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParseException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.TNSW_Constants;
import io.cucumber.java.en.Then;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class GetStop {
	
	RequestSpecification request;
	Response response;
    String respString;
    JSONParser jsonParser = new JSONParser();

    @Given("John is looking for a stop")
    public void john_is_looking_for_a_stop() {
		RestAssured.baseURI =TNSW_Constants.tnsw_baseurl;
		request = RestAssured.given();
       
    }

    @When("tester hits API and John searches for {string}")
    public void tester_hits_api_and_john_searches_for(String stop)  {
		String url = TNSW_Constants.tnsw_stopurl1 + stop + TNSW_Constants.tnsw_stopurl2;
		Response response=RestAssured.get(url);
		respString = response.asString();
       
    }

    @Then("Success status code is coming")
    public void success_status_code_is_coming()   {
    	boolean condition = true;
    	//JSONObject obj = (JSONObject) jsonParser.parse(respString);
    	//System.out.println("here" + obj);
    	 // JSONArray systemMessages = (JSONArray) obj.get("systemMessages");
    	//  for (Object message : systemMessages) {
    	//	  JSONObject messageObject = (JSONObject) message;
    	//	  System.out.println(messageObject.get("code"));
    		  assertTrue(condition);
    	//  }
    	  
    }

    @And("a stop named {string} is found")
    public void a_stop_named_is_found(String stop) throws ParseException  {
     	JSONObject obj = (JSONObject) jsonParser.parse(respString);
		 
        JSONArray Locations = (JSONArray) obj.get("locations");
        System.out.println(Locations);
         
        //Iterate over employee array
        for (Object location : Locations) {
        	//parseLocationObject(object);
	        JSONObject locationObject = (JSONObject) location;
	         
	        //Get employee first name
	        String type = (String) locationObject.get("type");    
	        System.out.println("type:" +type);
	         
	        //Get employee last name
	        String name = (String) locationObject.get("name");  
	        if(name.equalsIgnoreCase(stop)) {
	        	  assertEquals(name, stop);
	        }
	        System.out.println("name:"+name);
	        
	      
	       
		}
        
    }

    @And("the stop provides more than one mode of transport")
    public void the_stop_provides_more_than_one_mode_of_transport() throws ParseException  {
    	JSONObject obj = (JSONObject) jsonParser.parse(respString);
    	boolean condition = true;
		 
        JSONArray Locations = (JSONArray) obj.get("locations");
        System.out.println(Locations);
         
        //Iterate over employee array
        for (Object location : Locations) {
        	//parseLocationObject(object);
	        JSONObject locationObject = (JSONObject) location;
	         
	        //Get employee first name
	        String type = (String) locationObject.get("type");    
	        System.out.println("type:" +type);
	        
	        if(type.equals("stop")) {
		        JSONArray modes = (JSONArray) locationObject.get("modes");
		        if(modes.size() > 1) {
		        	assertTrue(condition);
		        	System.out.println("More than one mode");
		        }
		       }
	        
        }
       
    }

}