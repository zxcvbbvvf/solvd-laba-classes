package com.example.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TokenManager {
    private static String githubToken;

    static {
        try {
            Properties properties = new Properties();

            FileInputStream fls = new FileInputStream("C:/Users/Dustin_2/.github/secret.properties");
            properties.load(fls);
            githubToken = properties.getProperty("github_token");
            fls.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read token from file", e);
        }
    }

    public static String getToken() {
        return githubToken;
    }
}
