package com.api.base;

import static io.restassured.RestAssured.*;


import com.api.utils.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;



import static io.restassured.RestAssured.given;


public class BaseService {

    protected RequestSpecification request;

    public BaseService() {
        String baseUrl = ConfigReader.get("baseUrl");

        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException(" baseUrl is missing in config.properties");
        }

        request = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return request.body(payload).post(endpoint);
    }

    protected Response putRequest(Object body, String endpoint) {
        return request
                .body(body)
                .put(endpoint);
    }


    protected Response getRequest(String endpoint) {
        return request.get(endpoint);
    }

    protected Response deleteRequest(String endpoint) {
        return request.delete(endpoint);
    }
}
