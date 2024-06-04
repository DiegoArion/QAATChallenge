@Feature=Pet @Type=Positive
Feature: Endpoint Put \pet | Update an existing pet

  Scenario: Successfully update a pet
    Given I have the correct data to update an existing pet
    When I send the PUT request with the new data
    Then the response include the data I send
    And the status code, Successfully is 200

    @Type=Negative
  Scenario: Trying to update a pet with unregistered id
    Given I have an unregistered ID from a pet in the data like 110
    When I send the PUT request with the incorrect data
    Then the response body is "Pet not found"
    And the status code, Pet not found is 404

@Type=Negative
 Scenario: Trying to update a pet with invalid id
   Given I have an invalid ID like "a" in the data form a pet
   When I send the PUT request with the invalid ID
   Then the status code, Invalid ID Supplied is 400

