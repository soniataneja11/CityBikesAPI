Feature: Automation REST API Testing on CityBikes
  
  As a user I want to verify 
  that the city Frankfurt is in Germany 
  and return their corresponded latitude and longitude

@smoke
  Scenario Outline: As a user I want to verify that the city Frankfurt is in Germany and return their corresponding latitude and longitude
    Given I create a new citybikes endpoint
    When I send a valid GET request
    Then the status code shouldbe <statusCode>
    And  verify the "<city>" is in "<Country>"
    Then retrive the latitude and longitude of the "<city>"

     Examples: 
      | city      | Country   | statusCode |
      | Frankfurt | DE        |        200 |