Feature: Endpoint Get \store\inventory |  Returns pet inventory by status

  Scenario: Successfully get pet inventory by status
    Given endpoint store inventory is available
    When I send a GET request to endpoint store inventory
    Then the response status code for get the store inventory should be 200