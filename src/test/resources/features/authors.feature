Feature: Authors API

  Scenario: Get all authors
    Given the Authors API is available
    When user fetches all authors
    Then response status should be 200
    And response body should not be empty

  Scenario: Create a new author
    Given the Authors API is available
    And author create payload is
      | id | idBook | firstName       | lastName        |
      | 1  | 1      | my first book   | my last book    |
    When user creates a new author
    Then response status should be 200
    And response body should not be empty

  Scenario: Get authors by book id
    Given the Authors API is available
    When user fetches authors for book with id 1
    Then response status should be 200
    And response body should not be empty

  Scenario: Get author by id
    Given the Authors API is available
    When user fetches author with id 1
    Then response status should be 200
    And response body should not be empty

  Scenario: Update an existing author
    Given an author with id 1 exists
    And author update payload is
      | id | idBook | firstName  | lastName |
      | 1  | 1      | the atomic | habits   |
    When user updates author with id 1
    Then response status should be 200
    And response body should not be empty

  Scenario: Delete an existing author
    Given an author with id 1 exists
    When user deletes author with id 1
    Then response status should be 200