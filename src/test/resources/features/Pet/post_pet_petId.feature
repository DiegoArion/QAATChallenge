@Feature=Pet @Type=Positive
Feature: Endpoint Post \pet\petId |  Updates a pet in the store with form data

  Scenario: Updates a pet in the store with form data
    Given I have the ID from an existing pet with ID 10
    When I send a POST request to the endpoint with same pet ID 10 for set the name "kitty" and status "available"
    Then the response status code for post petId should be 200
    And the response should contain pets with status "<status>"