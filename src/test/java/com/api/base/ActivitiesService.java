package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.models.request.CreateActivityRequest;
import com.api.models.request.UpdateActivityRequest;
import io.restassured.response.Response;

public class ActivitiesService extends BaseService {

    private static final String BASE_PATH = "/api/v1/Activities";

    public Response getAllActivities() {
        return getRequest(BASE_PATH);
    }

    public Response createActivity(CreateActivityRequest request) {
        return postRequest(request, BASE_PATH);
    }

    public Response getActivityById(int id) {
        return getRequest(BASE_PATH + "/" + id);
    }

    public Response updateActivityById(int id, UpdateActivityRequest updateRequest) {
        return putRequest(updateRequest, BASE_PATH + "/" + id);
    }

    public Response deleteActivityById(int id) {
        return deleteRequest(BASE_PATH + "/" + id);
    }
}
