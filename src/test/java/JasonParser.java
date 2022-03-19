		import java.io.FileNotFoundException;
		import java.io.FileReader;
		import java.io.IOException;
		 
		import org.json.simple.JSONArray;
		import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
		import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.TNSW_Constants;
public class JasonParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 

		 

		        //JSON parser object to parse read file
		        JSONParser jsonParser = new JSONParser();
		         
		        try 
		        {
		            //Read JSON file
		        	String resp= "{\"version\":\"10.2.2.48\",\"systemMessages\":[{\"type\":\"error\",\"module\":\"BROKER\",\"code\":-8011,\"text\":\"\"}],\"locations\":[{\"id\":\"poiID:858293493:95301001:-1:Coles Supermarket, Wynyard Station:Sydney:Coles Supermarket, Wynyard Station:ANY:POI:4889178:3755232:GDAV:nsw\",\"name\":\"Coles Supermarket, Wynyard Station, Sydney\",\"disassembledName\":\"Coles Supermarket, Wynyard Station\",\"coord\":[3755232.0,4889178.0],\"type\":\"poi\",\"matchQuality\":237,\"isBest\":false,\"parent\":{\"id\":\"95301001|-1\",\"name\":\"Sydney\",\"type\":\"locality\"}},{\"id\":\"200080\",\"isGlobalId\":true,\"name\":\"Wynyard Station, Sydney\",\"disassembledName\":\"Wynyard Station\",\"coord\":[3755261.0,4889167.0],\"type\":\"stop\",\"matchQuality\":996,\"isBest\":true,\"modes\":[1,4,5,11],\"parent\":{\"id\":\"95301001|1\",\"name\":\"Sydney\",\"type\":\"locality\"},\"properties\":{\"stopId\":\"10101102\"}}]}";
		        	String respString =null;
		        	String url= TNSW_Constants.tnsw_stopurl1 + "Wynyard Station" + TNSW_Constants.tnsw_stopurl2;
		    		Response response=RestAssured.get(url);
		    		Object obj1 =  JSONValue.parse(response.getBody().asString());
		    		System.out.println(response.getBody().asString());
		    		System.out.println(obj1);
		        	JSONObject obj = (JSONObject) obj1;
		        			//jsonParser.parse(respString);
		        	System.out.println(obj1);
		            JSONArray Locations = (JSONArray) obj.get("locations");
		            System.out.println(Locations);
		             
		            //Iterate over employee array
		            for (Object object : Locations) {
		            	parseLocationObject(object);
					}
		            
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		 
		    private static void parseLocationObject(Object location) 
		    {
		        //Get employee object within list
		        JSONObject locationObject = (JSONObject) location;
		         
		        //Get employee first name
		        String type = (String) locationObject.get("type");    
		        System.out.println("type:" +type);
		         
		        //Get employee last name
		        String name = (String) locationObject.get("name");  
		        System.out.println("name:"+name);
		        
		       if(type.equals("stop")) {
		        JSONArray modes = (JSONArray) locationObject.get("modes");
		        if(modes.size() > 1) {
		        	System.out.println("More than one mode");
		        }
		       }
		        //Get employee website name
			    }
		}

	


