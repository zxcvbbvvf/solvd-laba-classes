package com.github.api;

import org.testng.annotations.BeforeClass;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;

import io.github.cdimascio.dotenv.Dotenv;

// Create a .env with your GitHub token
public abstract class BaseTest extends AbstractTest {

    @BeforeClass
    public void setUp() {
        // load .env file
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("GITHUB_TOKEN");

        // set up base url and token dynamically
        R.CONFIG.put("api_url", "https://api.github.com");
        R.CONFIG.put("token", token);
    }

    protected AbstractApiMethodV2 prepareApiMethod(AbstractApiMethodV2 apiMethod) {
        apiMethod.replaceUrlPlaceholder("api_url", R.CONFIG.get("api_url"));
        apiMethod.setHeader("Authorization", "Bearer " + R.CONFIG.get("token"));
        apiMethod.setHeader("Accept", "application/vnd.github+json");
        return apiMethod;
    }
}
