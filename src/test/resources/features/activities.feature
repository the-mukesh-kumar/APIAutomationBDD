Feature: Activities API

Feature: Activities API

  Scenario: Get all activities
    Given the Activities API is available
    When user fetches all activities
    Then response status should be 200
    And response body should not be empty


  Scenario: Create a new activity
    Given activity create payload is
      | id  | title | dueDate                  | completed |
      | 150 | test  | 2025-12-31T06:35:41.915Z | true      |
    When user creates a new activity
    Then response status should be 200
    And response should have id 150
    And response should have title "test"
    And response should have completed "true"

  Scenario: Update an existing activity
    Given an activity with id 1 exists
    And activity update payload is
      | id | title | dueDate                  | completed |
      | 1  | test  | 2025-12-31T11:44:52.879Z | true      |
    When user updates activity with id 1
    Then response status should be 200
    And response should have id 1
    And response should have title "test"
    And response should have completed "true"

  Scenario: Delete an existing activity
    Given an activity with id 1 exists
    When user deletes activity with id 1
    Then response status should be 200