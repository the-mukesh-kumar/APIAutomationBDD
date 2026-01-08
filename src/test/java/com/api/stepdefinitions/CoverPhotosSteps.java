package com.api.stepdefinitions;

import com.api.base.CoverPhotosService;
import com.api.context.TestContext;
import com.api.models.request.CoverPhotosRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CoverPhotosSteps {
    private CoverPhotosService coverPhotosService= new CoverPhotosService();
private CoverPhotosRequest coverPhotosRequest;


    @Given("the CoverPhotos API is available")
    public void the_cover_photos_api_is_available() {

    }
    @When("user fetches all cover photos")
    public void user_fetches_all_cover_photos() {
       TestContext.response=coverPhotosService.getAllCoverPhotos();
    }
    @Given("cover photo create payload is")
    public void cover_photo_create_payload_is(DataTable dataTable) {
        Map<String,String> data = dataTable.asMaps().get(0);
        coverPhotosRequest = new CoverPhotosRequest();
        coverPhotosRequest.setId(Integer.parseInt(data.get("id")));
        coverPhotosRequest.setIdBook(Integer.parseInt(data.get("idBook")));
        coverPhotosRequest.setUrl(data.get("url"));


    }
    @When("user creates a new cover photo")
    public void user_creates_a_new_cover_photo() {
  TestContext.response=  coverPhotosService.createCoverPhotos(coverPhotosRequest);
    }

    @When("user fetches cover photos for book with id {int}")
    public void user_fetches_cover_photos_for_book_with_id(Integer int1) {
        TestContext.response=  coverPhotosService.getCoverPhotosByBookId(int1);

    }

    @When("user fetches cover photo with id {int}")
    public void user_fetches_cover_photo_with_id(Integer int1) {
        TestContext.response=  coverPhotosService.getCoverPhotosById(int1);
    }



}
