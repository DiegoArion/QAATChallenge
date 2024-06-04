@Feature=Pet @Type=Positive
Feature: Endpoint Delete \pet\petId |  Deletes a pet

  Scenario: Successfully deletes a pet
    Given I have an existing pet with ID 10
    When I send a Delet request to the endpoint with same pet ID 10
    Then the response status code for delete petId should be 200
    And the response body should contain pets with status "Pet Deleted"