package com.api.stepdefinitions;

import com.api.context.TestContext;
import com.api.models.request.CreateActivityRequest;
import com.api.models.request.UpdateActivityRequest;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import com.api.base.ActivitiesService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class ActivitiesSteps {


    private final ActivitiesService activitiesService = new ActivitiesService();
    private CreateActivityRequest createActivityRequest;
    private UpdateActivityRequest updateActivityRequest;

    private static int tcno = 1;

    @Given("the Activities API is available")
    public void the_activities_api_is_available() {
        System.out.println("the Activities API is available");


    }
    @Given("activity create payload is")
    public void activity_create_payload_is(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);

        createActivityRequest = new CreateActivityRequest();
        createActivityRequest.setId(Integer.parseInt(data.get("id")));
        createActivityRequest.setTitle(data.get("title"));
        createActivityRequest.setDueDate(data.get("dueDate"));
        createActivityRequest.setCompleted(Boolean.parseBoolean(data.get("completed")));
    }

    @Given("an activity with id {int} exists")
    public void an_activity_with_id_exists(Integer id) {
        System.out.println("the Activities API is available");



    }



    @Given("activity update payload is")
    public void activity_update_payload_is(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);

        updateActivityRequest = new UpdateActivityRequest();
        updateActivityRequest.setId(Integer.parseInt(data.get("id")));
        updateActivityRequest.setTitle(data.get("title"));
        updateActivityRequest.setDueDate(data.get("dueDate"));
        updateActivityRequest.setCompleted(Boolean.parseBoolean(data.get("completed")));
    }



    @When("user fetches all activities")
    public void user_fetches_all_activities() {
        TestContext.response = activitiesService.getAllActivities();
        System.out.println(TestContext.response.asPrettyString());
    }

    @When("user fetches activity with id {int}")
    public void user_fetches_activity_with_id(Integer id) {
        TestContext.response = activitiesService.getActivityById(id);
    }

    @When("user creates a new activity")
    public void user_creates_a_new_activity() {
        TestContext.response = activitiesService.createActivity(createActivityRequest);
    }

    //
    @Then("response status should be {int}")
    public void response_status_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), TestContext.response.getStatusCode());
        System.out.println(tcno + "----------------------------");
        tcno++;
    }

    @Then("response body should not be empty")
    public void response_body_should_not_be_empty() {
        String responseBody = TestContext.response.getBody().asString();
        Assert.assertNotNull(responseBody);
        Assert.assertFalse(responseBody.isEmpty());
        System.out.println(TestContext.response.asPrettyString());

    }

    @Then("response should have id {int}")
    public void response_should_have_id(Integer expectedId) {

        int actualId = TestContext.response.jsonPath().getInt("id");
        Assert.assertEquals(expectedId.intValue(), actualId);
    }

    @Then("response should have title {string}")
    public void response_should_have_title(String expectedTitle) {

        String actualTitle = TestContext.response.jsonPath().getString("title");
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("response should have completed {string}")
    public void response_should_have_completed(String expectedCompleted) {

        boolean actualCompleted = TestContext.response.jsonPath().getBoolean("completed");
        boolean expected = Boolean.parseBoolean(expectedCompleted);

        Assert.assertEquals(expected, actualCompleted);
    }

    @When("user updates activity with id {int}")
    public void user_updates_activity_with_id(Integer id) {
        TestContext.response = activitiesService.updateActivityById(id, updateActivityRequest);
    }

    @When("user deletes activity with id {int}")
    public void user_deletes_activity_with_id(Integer id) {
        TestContext.response = activitiesService.deleteActivityById(id);
    }

}
