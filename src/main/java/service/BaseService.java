package service;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import spec.RequestSpec;
import model.Character;

import static io.restassured.RestAssured.given;

public class BaseService extends RequestSpec {

    public BaseService() {
        super("https://rickandmortyapi.com/api");
    }

    public Response GetAll(String path, ResponseSpecification responseSpecification) {

        return given()
                .spec(super.getRequestSpecification())
                .get(path)
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
    }
}
