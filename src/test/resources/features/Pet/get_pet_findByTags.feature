@Feature=Pet @Type=Positive
Feature: Endpoint Get \pet\findByTags | Find pet by tags

  Scenario: Find pets by tag
    Given the API endpoint for finding pets by tags is available
    When I send a GET request to endpoint with tags "<status>"
    Then the response status code for findByTags endpoint should be 200
    And the response should contain pets with tags "<status>"