package com.api.base;

import com.api.models.request.CoverPhotosRequest;
import com.api.models.request.CreateActivityRequest;
import com.api.models.request.UpdateActivityRequest;
import io.restassured.response.Response;

public class CoverPhotosService extends BooksService{

    private static final String BASE_PATH = "/api/v1/CoverPhotos";

    public Response getAllCoverPhotos() {
        return getRequest(BASE_PATH);
    }

    public Response createCoverPhotos(CoverPhotosRequest request) {
        return postRequest(request, BASE_PATH);
    }

    public Response getCoverPhotosById(int id) {
        return getRequest(BASE_PATH + "/" + id);
    }

    public Response updateCoverPhotosById(int id, UpdateActivityRequest updateRequest) {
        return putRequest(updateRequest, BASE_PATH + "/" + id);
    }

    public Response deleteCoverPhotosById(int id) {
        return deleteRequest(BASE_PATH + "/" + id);
    }
}
