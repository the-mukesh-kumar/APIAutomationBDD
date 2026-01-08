package com.api.stepdefinitions;

import com.api.base.BooksService;
import com.api.context.TestContext;
import com.api.models.request.CreateBookRequest;
import com.api.models.request.UpdateBookRequest;
import com.api.models.response.CreateBookResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;


public class BooksSteps {

    BooksService booksService= new BooksService();
    private CreateBookRequest createBookRequest;
    CreateBookResponse createBookResponse = new CreateBookResponse() ;
    UpdateBookRequest updateBookRequest  ;


    @Given("the Books API is available")
    public void the_books_api_is_available() {

    }
    @When("user fetch all books")
    public void user_fetch_all_books() {
        TestContext.response= booksService.getAllBooks();
    }

    @Given("book create payload is")
    public void book_create_payload_is(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);

        createBookRequest = new CreateBookRequest();
        createBookRequest.setId(Integer.parseInt(data.get("id")));
        createBookRequest.setTitle(data.get("title"));
        createBookRequest.setDescription(data.get("description"));
        createBookRequest.setPageCount(Integer.parseInt(data.get("pageCount")));
        createBookRequest.setExcerpt(data.get("excerpt"));
        createBookRequest.setPublishDate(data.get("publishDate"));
    }

    @When("user creates a new book")
    public void user_creates_a_new_book() {
        TestContext.response=    booksService.createBook(createBookRequest);
        createBookResponse = TestContext.response.as(CreateBookResponse.class);

        System.out.println( createBookResponse.getDescription());
    }
    @Then("response should have description {string}")
    public void response_should_have_description(String string) {
        String actualDescription = createBookResponse.getDescription();

        Assert.assertEquals(string,actualDescription);

    }
    @When("user fetches book with id {int}")
    public void user_fetches_book_with_id(Integer id) {
        TestContext.response=  booksService.getBookById(id);
    }

    @Given("a book with id {int} exists")
    public void a_book_with_id_exists(Integer int1) {

    }
    @Given("book update payload is")
    public void book_update_payload_is(DataTable dataTable) {
       Map<String, String> data = dataTable.asMaps().get(0);

        updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setId(Integer.parseInt(data.get("id")));
        updateBookRequest.setTitle(data.get("title"));
        updateBookRequest.setDescription(data.get("description"));
        updateBookRequest.setPageCount(Integer.parseInt(data.get("pageCount")));
        updateBookRequest.setExcerpt(data.get("excerpt"));
        updateBookRequest.setPublishDate(data.get("publishDate"));

    }
    @When("user updates book with id {int}")
    public void user_updates_book_with_id(Integer int1) {
        TestContext.response=     booksService.updateBook(updateBookRequest, int1);
    }
    @When("user deletes book with id {int}")
    public void user_deletes_book_with_id(Integer int1) {
       TestContext.response= booksService.deleteBook(int1);
    }


}
