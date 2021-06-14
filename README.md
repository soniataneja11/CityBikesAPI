serenity.propertiesExcercise 2: - Create some BDD Scenarios and automate then using Java to test the API
===========================

Scope:
---------
Write BDD format to understand the API endpoint, test the endpoint with Java language, 
given a scenario, eg: `As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude`

Feature uses a Scenario Outline: so other cities can be added to Examples
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

Key aspects
---------
IDE used - Eclipse
Project type - Maven
Language - Java
Dependencies - refer pom.xml

You will need:
- Java 1.8+ installed (Does not work with Java below 1.8) [I ran it on JDK 16 as well]
- Maven Installed (I use version 3.5.2) 
- Eclipse (Or another Java IDE)

How to execute
---------
Project can be cloned from github and built locally through terminal console

In order to execute navigate to the Project directory within a Terminal/CMD window and run the command: **'mvn clean test'**.

The Framework also has Serenity reporting feature added which can be accessed at target/site/serenity/index.html


