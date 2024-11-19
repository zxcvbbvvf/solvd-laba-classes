package com.github.api;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.api.methods.CloseIssueMethod;
import com.github.api.methods.CreateIssueMethod;
import com.github.api.methods.CreateRepoMethod;
import com.github.api.methods.DeleteRepoMethod;
import com.github.api.methods.GetIssueMethod;
import com.github.api.methods.GetRepoMethod;
import com.github.api.methods.ListIssuesMethod;
import com.github.api.methods.UpdateIssueMethod;
import com.github.api.methods.UpdateRepoMethod;
import com.github.api.pojo.Repository;

import io.restassured.response.Response;

//replace "username" with your GitHub username
public class GitHubApiTests extends BaseTest {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    // 1. Create a new repository using the Repository class
    @Test(priority=1)
    public void testCreateRepo() throws IOException {
        Repository repo = new Repository("test-repo", "test description", false);
        String payload = objectMapper.writeValueAsString(repo);

        CreateRepoMethod createRepo = new CreateRepoMethod();
        createRepo.setRequestBody(payload);

        prepareApiMethod(createRepo);
        Response response = createRepo.callAPI();

        response.then().statusCode(201);
    }

    // 2. Verify the repository details after creation
    @Test(priority = 2)
    public void testGetRepoDetails() {
        GetRepoMethod getRepo = new GetRepoMethod("username", "test-repo");

        prepareApiMethod(getRepo);
        Response response = getRepo.callAPI();

        response.then().statusCode(200);
    }

    // 3. Update the repository's description
    @Test(priority = 3)
    public void testUpdateRepoDetails() throws IOException {
        String payload = "{ \"name\": \"test-repo\", \"description\": \"Updated description\", \"private\": false }";

        UpdateRepoMethod updateRepo = new UpdateRepoMethod("username", "test-repo");
        updateRepo.setRequestBody(payload);

        prepareApiMethod(updateRepo);
        Response response = updateRepo.callAPI();

        response.then().statusCode(200);
    }

    // 4. Create a new issue
    @Test(priority = 4)
    public void testCreateIssue() {
        String payload = "{\"title\": \"Bug found\", \"body\": \"Details of the bug\"}";

        CreateIssueMethod createIssue = new CreateIssueMethod("username", "test-repo");
        createIssue.setRequestBody(payload);

        prepareApiMethod(createIssue);
        Response response = createIssue.callAPI();

        response.then().statusCode(201);
    }

    // 5. Verify the issue details
    @Test(priority = 5)
    public void testGetIssueDetails() {
        GetIssueMethod getIssue = new GetIssueMethod("username", "test-repo", 1);

        prepareApiMethod(getIssue);
        Response response = getIssue.callAPI();

        response.then().statusCode(200);
    }

    // 6. Update the issue details
    @Test(priority = 6)
    public void testUpdateIssue() {
        String payload = "{\"title\": \"Bug fixed\", \"body\": \"Updated details\"}";

        UpdateIssueMethod updateIssue = new UpdateIssueMethod("username", "test-repo", 1);
        updateIssue.setRequestBody(payload);

        prepareApiMethod(updateIssue);
        Response response = updateIssue.callAPI();

        response.then().statusCode(200);
    }

    // 7. Close the issue
    @Test(priority = 7)
    public void testCloseIssue() {
        CloseIssueMethod closeIssue = new CloseIssueMethod("username", "test-repo", 1);

        prepareApiMethod(closeIssue);
        Response response = closeIssue.callAPI();

        response.then().statusCode(200);
    }

    // 8. List all issues in the repository
    @Test(priority = 8)
    public void testListIssues() {
        ListIssuesMethod listIssues = new ListIssuesMethod("username", "test-repo");

        prepareApiMethod(listIssues);
        Response response = listIssues.callAPI();

        response.then().statusCode(200);
    }

    // 9. Verify the repository exists
    @Test(priority = 9)
    public void testVerifyRepoExists() {
        GetRepoMethod verifyRepo = new GetRepoMethod("username", "test-repo");

        prepareApiMethod(verifyRepo);
        Response response = verifyRepo.callAPI();

        response.then().statusCode(200);
    }

    // 10. Delete the repository
    @Test(priority = 10)
    public void testDeleteRepo() {
        DeleteRepoMethod deleteRepo = new DeleteRepoMethod("username", "test-repo");

        prepareApiMethod(deleteRepo);
        Response response = deleteRepo.callAPI();

        response.then().statusCode(204);
    }
}
