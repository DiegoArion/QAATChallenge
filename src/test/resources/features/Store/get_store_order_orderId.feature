Feature: Endpoint Get \store\order\orderId |  Find purchase order by ID

  Scenario: Successfully Find purchase order by ID
    Given I have a valid ID as 10
    When I send a GET request with the order ID in the path
    Then the response status code for get the order should be 200