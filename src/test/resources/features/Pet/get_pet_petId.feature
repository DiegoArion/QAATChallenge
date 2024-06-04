@Feature=Pet @Type=Positive
Feature: Endpoint Get \pet\petId | Find pet by ID

  Scenario: Find pets by ID
    Given the API endpoint for finding pets by ID is available
    When I send a GET request to endpoint with ID 10
    Then the response status code for petId should be 200
    And the response should contain pets with status "<status>"