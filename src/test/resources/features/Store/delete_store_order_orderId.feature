Feature: Endpoint Delete \store\order\orderId |  Delete purchase order by ID

  Scenario: Successfully Delete purchase order by ID
    Given I have a valid ID from an existent order to be deleted, as 10
    When I send a DELETE request with the order ID in the path
    Then the response status code for delete the order should be 200