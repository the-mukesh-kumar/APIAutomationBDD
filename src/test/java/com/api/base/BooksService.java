package com.api.base;

import com.api.models.request.CreateBookRequest;
import com.api.models.request.UpdateBookRequest;
import io.restassured.response.Response;

public class BooksService extends BaseService{

    private final static String BASE_PATH="/api/v1/Books";

    public Response getAllBooks(){
        return getRequest(BASE_PATH);
    }

    public Response createBook(CreateBookRequest createBookRequest){
        return postRequest(createBookRequest, BASE_PATH);
    }
    public Response getBookById(int id){
        return getRequest( BASE_PATH);
    }

    public Response updateBook(UpdateBookRequest updateBookRequest, int id){
        return postRequest(updateBookRequest, BASE_PATH);
    }
    public Response deleteBook(int id){
        return deleteRequest(BASE_PATH+"/"+id);
    }


}
