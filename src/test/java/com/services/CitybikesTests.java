package com.services;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import com.setUp.TestSetup;



public class CitybikesTests extends TestSetup {
	
	 
	
	public Response doGetRequest(){
		
		RestAssured.defaultParser = Parser.JSON;
		
		Response response = given().
							when().
							get(configProperties.getBaseURI()+configProperties.getBasePath())
							.then().extract().response();
		
		return response;
	}
		

	public int parseJsontoSearchCity(Response response, String City) {
		List<String> Citys=response.path("networks.location.city");
		int index = 0;
		for (String city : Citys) {
	        index++;
			if ((city.toString()).equalsIgnoreCase(City)) {
				String Country = response.path("networks["+index+"].location.country");
				//assertThat(Country.toString().equals("DE"));
			}
		}
			return index;
		
	}
		
		
		public void getCoOrdinates(Response response, int index) {
				float latitude = response.path("networks["+index+"].location.latitude");
				float longitude = response.path("networks["+index+"].location.longitude");
				System.out.println("Latitude : "+ latitude );
				System.out.println("Longitude : "+ longitude);
		}
		
		
	}
