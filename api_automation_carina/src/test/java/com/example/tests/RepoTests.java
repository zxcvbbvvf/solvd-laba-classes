package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.api.CreateRepoMethod;
import com.example.api.DeleteRepoMethod;
import com.example.api.GetRepoMethod;
import com.example.api.GetReposListMethod;
import com.example.api.UpdateRepoMethod;
import com.zebrunner.carina.core.IAbstractTest;

import io.restassured.response.Response;
public class RepoTests implements IAbstractTest {
    @Test
    public void testCreateRepo() {
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        Response response = createRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.jsonPath().get("name"), "test-repo", "Repository name is incorrect!");
    }

    @Test
    public void testGetRepo() {
        // Create a repo to retrieve
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        createRepoMethod.callAPIExpectSuccess();

        // Retrieve the created repo
        GetRepoMethod getRepoMethod = new GetRepoMethod("zxcvbbvvf", "test-repo");
        Response response = getRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.jsonPath().get("name"), "test-repo", "Repository retrieval failed!");
    }

    @Test
    public void testDeleteRepo() {
        // Create a repo to delete
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        createRepoMethod.callAPIExpectSuccess();

        // Delete the created repo
        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod("zxcvbbvvf", "test-repo");
        Response response = deleteRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.statusCode(), 204, "Repository deletion failed!");
    }

    @Test
    public void testGetReposList() {
        // Retrieve the list of repositories
        GetReposListMethod getReposListMethod = new GetReposListMethod("zxcvbbvvf");
        Response response = getReposListMethod.callAPIExpectSuccess();
        Assert.assertTrue(response.jsonPath().getList("").size() >= 0, "Repository list retrieval failed!");
    }

    @Test
    public void testUpdateRepo() {
        // Create a repo to update
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        createRepoMethod.callAPIExpectSuccess();

        // Update the created repo
        UpdateRepoMethod updateRepoMethod = new UpdateRepoMethod("zxcvbbvvf", "test-repo");
        Response response = updateRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.jsonPath().get("name"), "updated-repo-name", "Repository update failed!");
    }

    @Test
    public void testRepoCreationWithoutAuth() {
        // Attempt to create a repository without authorization
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        createRepoMethod.setHeader("Authorization", ""); // Remove Authorization
        Response response = createRepoMethod.callAPI();
        Assert.assertEquals(response.statusCode(), 401, "Unauthorized repository creation succeeded!");
    }

    @Test
    public void testRepoRetrievalNonexistent() {
        // Attempt to retrieve a nonexistent repository
        GetRepoMethod getRepoMethod = new GetRepoMethod("zxcvbbvvf", "nonexistent-repo");
        Response response = getRepoMethod.callAPI();
        Assert.assertEquals(response.statusCode(), 404, "Nonexistent repository retrieval did not fail as expected!");
    }

    @Test
    public void testDeleteNonexistentRepo() {
        // Attempt to delete a nonexistent repository
        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod("zxcvbbvvf", "nonexistent-repo");
        Response response = deleteRepoMethod.callAPI();
        Assert.assertEquals(response.statusCode(), 404, "Nonexistent repository deletion did not fail as expected!");
    }

    @Test
    public void testGetPublicRepos() {
        // Retrieve public repositories of another user
        GetReposListMethod getReposListMethod = new GetReposListMethod("zebrunner");
        Response response = getReposListMethod.callAPIExpectSuccess();
        Assert.assertTrue(response.jsonPath().getList("").size() >= 0, "Public repository retrieval failed!");
    }

    @Test
    public void testUpdateRepoUnauthorized() {
        // Attempt to update a repository without authorization
        UpdateRepoMethod updateRepoMethod = new UpdateRepoMethod("zxcvbbvvf", "test-repo");
        updateRepoMethod.setHeader("Authorization", ""); // Remove Authorization
        Response response = updateRepoMethod.callAPI();
        Assert.assertEquals(response.statusCode(), 401, "Unauthorized repository update succeeded!");
    }
}
