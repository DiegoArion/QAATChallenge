@Feature=Pet @Type=Positive
Feature: Endpoint Get \pet\findByStatus | Find pet by status

  @Data=Multiple
  Scenario Outline: Find pets by different statuses
    Given the API endpoint for finding pets by status is available
    When I send a GET request to endpoint with status "<status>"
    Then the response status code should be 200
    And the response should contain pets with status "<status>"

    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |