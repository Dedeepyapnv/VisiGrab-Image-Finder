package com.eulerity.hackathon.imagefinder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonArray;

@WebServlet("/getImages")
public class ImageFinderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        String action = request.getParameter("action");

        if (url == null || action == null) {
            response.setStatus(400); // Bad request
            return;
        }

        if ("getHtmlContent".equals(action)) {
            // Get HTML content
            String htmlContent = ImageFinder.getImagesFromUrl(url);

            // Set content type and write HTML response
            response.setContentType("text/html");
            response.getWriter().println(htmlContent);
        } else if ("getJsonArray".equals(action)) {
            // Get JSON array of image URLs
            JsonArray jsonImageUrls = ImageFinder.getImagesUrlsJson(url);

            // Set content type and write JSON response
            response.setContentType("application/json");
            response.getWriter().println(jsonImageUrls.toString());
        } else {
            response.setStatus(400); // Bad request for unsupported action
        }
    }
}