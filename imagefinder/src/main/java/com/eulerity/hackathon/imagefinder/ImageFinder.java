package com.eulerity.hackathon.imagefinder;

import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageFinder {

    private static final Map<String, String> htmlCache = new HashMap<>();
    private static final Map<String, JsonArray> urlCache = new HashMap<>();

    public static String getImagesFromUrl(String url) throws IOException {
        if (htmlCache.containsKey(url)) {
            return htmlCache.get(url);
        }

        StringBuilder htmlBuilder = new StringBuilder();

        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img[src]");

        for (Element image : images) {
            String imgURL = image.attr("src");
            htmlBuilder.append("<img src=\"" + imgURL + "\">");
        }

        String htmlContent = htmlBuilder.toString();
        htmlCache.put(url, htmlContent); // Cache the HTML content

        return htmlContent;
    }

    public static JsonArray getImagesUrlsJson(String url) {
        if (urlCache.containsKey(url)) {
            return urlCache.get(url);
        }

        JsonArray jsonImageUrls = new JsonArray();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements images = doc.select("img[src]");

            for (Element image : images) {
                String imgUrl = image.attr("src");
                JsonObject imgObject = new JsonObject();
                imgObject.addProperty("url", imgUrl);
                jsonImageUrls.add(imgObject);
            }

            urlCache.put(url, jsonImageUrls); // Cache the JSON array of URLs
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception or return empty array based on your requirements
        }

        return jsonImageUrls;
    }
    //The below utility function Checks whether the provided url is within the same domain as the base URL or domain of my application.
     //private static boolean isSameDomain(String url) {
       // try {
         //      URI inputURI = new URI(url);
           //     URI baseURI = new URI(""); // Replace with the base URL or domain of your application

            // Compare host names to check if they are within the same domain
               //return inputURI.getHost().equalsIgnoreCase(baseURI.getHost());
            //} catch (URISyntaxException e) {
              //     e.printStackTrace();
                //   return false;
                 //}
    //}
    
}
