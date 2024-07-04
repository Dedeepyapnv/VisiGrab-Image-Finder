package com.eulerity.hackathon.imagefinder;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class ImageFinderTest {

    @Test
    void testGetImagesFromUrl() throws IOException {
        String testUrl = "https://www.w3schools.com/html/html_images.asp"; // Replace with your desired test URL
        //String expectedHtml = "..."; // Replace with expected HTML content containing image elements (optional)

        String actualHtml = ImageFinder.getImagesFromUrl(testUrl);

        // Assert that the returned HTML string contains expected image elements
        assertTrue(actualHtml.matches("<img.*src=\".*?\">"));
        // You can add more specific assertions based on your image selector
    }
}
