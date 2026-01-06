package com.api.stepdefinitions;

import com.api.base.AuthorsService;
import com.api.context.TestContext;
import com.api.models.request.CreateAuthorRequest;
import com.api.models.request.UpdateActivityRequest;
import com.api.models.request.UpdateAuthorRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.awt.*;
import java.util.Map;

public class AuthorsSteps {
    private Response response;
    private final AuthorsService authorsService = new AuthorsService();
    private CreateAuthorRequest createAuthorRequest;
    private UpdateAuthorRequest updateAuthorRequest;

    @Given("the Authors API is available")
    public void the_authors_api_is_available() {

    }

    @When("user fetches all authors")
    public void user_fetches_all_authors() {
        TestContext.response = authorsService.getAllAuthors();
    }

    @Given("author create payload is")
    public void author_create_payload_is(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);

        createAuthorRequest = new CreateAuthorRequest();
        createAuthorRequest.setId(Integer.parseInt(data.get("id")));
        createAuthorRequest.setIdBook(Integer.parseInt(data.get("idBook")));
        createAuthorRequest.setFirstName(data.get("firstName"));
        createAuthorRequest.setLastName(data.get("lastName"));
    }
    @When("user creates a new author")
    public void user_creates_a_new_author() {
        TestContext.response= authorsService.createAuthor(createAuthorRequest);

    }
    @When("user fetches authors for book with id {int}")
    public void user_fetches_authors_for_book_with_id(Integer authorId) {
        TestContext.response=  authorsService.getAuthorByBookId(authorId);
    }
    @When("user fetches author with id {int}")
    public void user_fetches_author_with_id(Integer authorId) {

        TestContext.response=  authorsService.getAuthorsById(authorId);
    }

    @Given("an author with id {int} exists")
    public void an_author_with_id_exists(Integer int1) {

    }
    @Given("author update payload is")
    public void author_update_payload_is(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        updateAuthorRequest = new UpdateAuthorRequest();
        updateAuthorRequest.setId(Integer.parseInt(data.get("id")));
        updateAuthorRequest.setIdBook(Integer.parseInt(data.get("idBook")));
        updateAuthorRequest.setFirstName(data.get("firstName"));
                updateAuthorRequest.setLastName(data.get("lastName"));


    }
    @When("user updates author with id {int}")
    public void user_updates_author_with_id(Integer authorId) {

        TestContext.response=  authorsService.updateAuthor(authorId,updateAuthorRequest);
    }
    @When("user deletes author with id {int}")
    public void user_deletes_author_with_id(Integer id) {
        TestContext.response=   authorsService.deleteAuthor(id);
    }
    }
