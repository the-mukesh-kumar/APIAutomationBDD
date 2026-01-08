Feature: Books API

  Scenario: Get all books
    Given the Books API is available
    When user fetch all books
    Then response status should be 200
    And response body should not be empty

    Scenario: Create a new book
      Given book create payload is
      | id | title | description        | pageCount | excerpt           | publishDate                         |
      | 1  | book1 | book 1 description | 0         | Lorem lorem lorem | 2026-01-06T05:41:20.1498645+00:00   |
      When user creates a new book
      Then response status should be 200
      Then response body should not be empty
      And response should have title "book1"
      And response should have description "book 1 description"

  Scenario: Get book by id
    Given the Books API is available
    When user fetches book with id 1
    Then response status should be 200
    And response body should not be empty

  Scenario: Update an existing book
    Given a book with id 1 exists
    And book update payload is
      | id | title       | description        | pageCount | excerpt       | publishDate                  |
      | 0  | test title  | test description   | 0         | test excerpt  | 2026-01-07T09:49:00.003Z     |
    When user updates book with id 1
    Then response status should be 200
    And response body should not be empty

  Scenario: Delete an existing book
    Given a book with id 1 exists
    When user deletes book with id 1
    Then response status should be 200