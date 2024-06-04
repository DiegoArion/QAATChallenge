@Feature=Pet @Type=Positive
Feature: Endpoint Post \pet | Create a new pet to the store

  Scenario: Successfully create a new pet to the store
    Given I have a valid data to create a new pet
    When I send the POST request with the valid data
    Then the response include the valid new pet data I send
    And the status code for the post pet is 200

  Scenario Outline: Successfully create 3 new pets to store
      Given I have valid data with "<id>", "<name>", "<category_id>", "<category_name>", "<photo_url>", "<tag_id>", "<tag_name>" and "<status>" for 3 new pets
      When I send the post with all the data for each pet
      Then the response include the data of each pet
      And the status code for each request is 200

    Examples:
      | id | name | category_id | category_name | photo_url | tag_id | tag_name | status |
      | 71 | Li   |     71      |   Lion        | lionphoto |   71   | lionsting  | available |
      | 72 | Do   |     72      |     Dolphin   |  dolphinphoto  | 72  | dolphinstring | pending |
      | 73 | Ca   |     73      |        Cat    | catphoto  |   73   | catstring | sold  |