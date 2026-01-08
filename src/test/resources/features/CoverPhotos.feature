Feature: CoverPhotos API

  Scenario: Get all cover photos
    Given the CoverPhotos API is available
    When user fetches all cover photos
    Then response status should be 200
    And response body should not be empty

  Scenario: Create a new cover photo
    Given the CoverPhotos API is available
    And cover photo create payload is
      | id | idBook | url                                                                 |
      | 1  | 1      | https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 1&w=250&h=350 |
    When user creates a new cover photo
    Then response status should be 200
    And response body should not be empty