Feature: Endpoint Post \store\order |  Place an order for a pet

  Scenario: Successfully place and order for a pet
    Given I have and valid store order data
    When I send a POST request with the store order data in the body
    Then the response status code for post the order should be 200