package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.api.CreateRepoMethod;
import com.example.api.DeleteRepoMethod;
import com.example.api.GetRepoMethod;
import com.example.api.GetReposListMethod;
import com.example.api.TokenManager;
import com.example.api.UpdateRepoMethod;
import com.zebrunner.carina.core.IAbstractTest;

import io.restassured.response.Response;
public class RepoTests implements IAbstractTest {
    @Test
    public void testCreateRepo() {
        CreateRepoMethod createRepoMethod = new CreateRepoMethod();
        Response response = createRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.jsonPath().get("name"), "test-repo", "Repo name is incorrect!");
    }

    @Test
    public void testGetRepo() {
        GetRepoMethod getRepoMethod = new GetRepoMethod("zxcvbbvvf", "test-repo");
        getRepoMethod.addParameter("Authorization", "Beaerer " + TokenManager.getToken());
        getRepoMethod.callAPIExpectSuccess();
    }

    @Test
    public void testUpdateRepo() {
        UpdateRepoMethod updateRepoMethod = new UpdateRepoMethod("zxcvbbvvf", "test-repo");
        updateRepoMethod.addParameter("Authorization", "Beaerer " + TokenManager.getToken());
        Response response = updateRepoMethod.callAPIExpectSuccess();
        Assert.assertEquals(response.jsonPath().get("description"), "Updated description", "Repo description is incorrect!");
    }

    @Test
    public void testDeleteRepo() {
        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod("zxcvbbvvf", "test-repo");
        deleteRepoMethod.addParameter("Authorization", "Beaerer " + TokenManager.getToken());
        deleteRepoMethod.callAPIExpectSuccess();
    }

    @Test
    public void testGetReposList() {
        GetReposListMethod getReposListMethod = new GetReposListMethod("zxcvbbvvf");
        getReposListMethod.addParameter("Authorization", "Beaerer " + TokenManager.getToken());
        getReposListMethod.callAPIExpectSuccess();
    }
}
