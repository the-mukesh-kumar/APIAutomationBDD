package com.api.base;

import com.api.models.request.CreateAuthorRequest;
import com.api.models.request.UpdateAuthorRequest;
import io.restassured.response.Response;

public class AuthorsService extends BaseService{

    private static final String BASE_PATH = "/api/v1/Authors";

    public Response getAllAuthors() {
        return getRequest(BASE_PATH);
    }

    public Response createAuthor(CreateAuthorRequest createAuthorRequest){
        return postRequest(createAuthorRequest,BASE_PATH);
    }

    public Response getAuthorByBookId(int bookId) {
        return getRequest(BASE_PATH + "/" + bookId);
    }

    public Response getAuthorsById(int authorId){
        return getRequest(BASE_PATH+"/"+authorId);
    }

    public Response updateAuthor(int id,UpdateAuthorRequest updateAuthorRequest){
        return postRequest(updateAuthorRequest,BASE_PATH);
    }
    public Response deleteAuthor(int id){
        return deleteRequest(BASE_PATH + "/" + id);
    }
}
