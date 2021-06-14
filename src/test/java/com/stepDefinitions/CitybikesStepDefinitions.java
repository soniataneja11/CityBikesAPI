package com.stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CitybikesStepDefinitions {

	private String path;
	private Response response;

	int index = 0;

	@Given("^I create a new citybikes endpoint$")
	public void i_create_a_new_citybikes_endpoint() {

		RestAssured.baseURI = "http://api.citybik.es";
		path = "/v2/networks";
	}

	@When("^I send a valid GET request$")
	public void i_send_a_valid_GET_request() {
		// Write code here that turns the phrase above into concrete actions
		response = given().when().get(path).then().extract().response();

	}

	@Then("^the status code shouldbe (\\d+)$")
	public void the_status_code_shouldbe(int statusCode) {
		System.out.println("Status Code -----------> " + response.getStatusCode());
		Assert.assertEquals(statusCode, response.getStatusCode());

	}

	@Then("^verify the \"([^\"]*)\" is in \"([^\"]*)\"$")
	public void verify_the_is_in(String searchCity, String MatchCountry) {

		List<String> CityList = response.path("networks.location.city");

		for (String city : CityList) {
			index++;
			if ((city.toString()).equals(searchCity)) {
				String ResponceCountry = response.path("networks[" + index + "].location.country");
				assertEquals(ResponceCountry, MatchCountry);
				System.out.println("Country -----------> " + ResponceCountry);
				break;
			}
		}
	}

	@Then("^retrive the latitude and longitude of the \"([^\"]*)\"$")
	public void retrive_the_latitude_and_longitude_of_the(String arg1) {

		float latitude = response.path("networks[" + index + "].location.latitude");
		float longitude = response.path("networks[" + index + "].location.longitude");
		System.out.println("Latitude -----------> " + latitude);
		System.out.println("Longitude ----------->	 " + longitude);

	}

}