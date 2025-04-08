package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiTest {

    // 1. Enhanced GET test
    @Test
    public void testGetRequest() {
        try {
            Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

            Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200");

            String responseBody = response.getBody().asString();
            Assert.assertNotNull(responseBody, "Response body should not be null");

            Assert.assertTrue(responseBody.contains("userId"), "Response should contain 'userId'");
            Assert.assertTrue(responseBody.contains("title"), "Response should contain 'title'");
            Assert.assertTrue(responseBody.contains("body"), "Response should contain 'body'");

            int userId = response.jsonPath().getInt("userId");
            Assert.assertEquals(userId, 1, "Expected userId = 1");

            System.out.println("testGetRequest passed.");
        } catch (Exception e) {
            System.err.println("testGetRequest failed due to exception: " + e.getMessage());
            Assert.fail("Exception during testGetRequest: " + e.getMessage());
        }
    }

    // 2. Handle non-existent post scenario
    @Test
    public void testInvalidId() {
        try {
            Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/99999");

            Assert.assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 for invalid ID");

            String responseBody = response.getBody().asString();
            Assert.assertEquals(responseBody.trim(), "{}", "Expected empty JSON for invalid post");

            System.out.println("testInvalidId passed.");
        } catch (Exception e) {
            System.err.println("testInvalidId failed: " + e.getMessage());
            Assert.fail("Exception during testInvalidId: " + e.getMessage());
        }
    }

    //  3. Data-driven testing with multiple IDs
    @DataProvider(name = "postIds")
    public Object[][] postIds() {
        return new Object[][]{
                {1, 1},
                {2, 1},
                {3, 1},
                {4, 1}
        };
    }

    @Test(dataProvider = "postIds")
    public void testMultiplePosts(int postId, int expectedUserId) {
        try {
            Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + postId);
            Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 for post ID: " + postId);

            int userId = response.jsonPath().getInt("userId");
            Assert.assertEquals(userId, expectedUserId, "Expected userId for post ID " + postId);

            System.out.println("testMultiplePosts passed for post ID: " + postId);
        } catch (Exception e) {
            System.err.println("testMultiplePosts failed for post ID: " + postId + ". Error: " + e.getMessage());
            Assert.fail("Exception for post ID " + postId + ": " + e.getMessage());
        }
    }
}
