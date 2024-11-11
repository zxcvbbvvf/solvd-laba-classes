package com.solvd.student.charles_borabon.rest_api;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class Main {

    @Test
    public void createUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        
        String requestBody = "{ \"name\": \"John\", \"job\": \"Developer\" }";
        
        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .extract().response();
    
        System.out.println("Create User Response: " + response.asString());
    }

    @Test
    public void getUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        
        Response response = given()
            .when()
            .get("/users/2")
            .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", notNullValue())
            .extract().response();

        System.out.println("Get User Response: " + response.asString());
    }

    @Test
    public void updateUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        
        String requestBody = "{ \"name\": \"Jane\", \"job\": \"Manager\" }";
        
        Response response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .put("/users/2")
            .then()
            .statusCode(200)
            .body("job", equalTo("Manager"))
            .extract().response();

        System.out.println("Update User Response: " + response.asString());
    }

    @Test
    public void deleteUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        
        Response response = given()
            .when()
            .delete("/users/2")
            .then()
            .statusCode(204)  // 204 No Content for a successful delete
            .extract().response();

        System.out.println("Delete User Response Status Code: " + response.getStatusCode());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.createUser();
        main.getUser();
        main.updateUser();
        main.deleteUser();
    }
}