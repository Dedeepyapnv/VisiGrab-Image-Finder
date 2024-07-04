# VisiGrab : ImageFinder

## Project Overview

ImageFinder is a web crawler designed to extract image URLs from a specified web page and its sub-pages. This project leverages Jsoup, a powerful HTML parser library for Java, to navigate and scrape web content. The crawler efficiently handles multiple sub-pages using multi-threading and ensures it remains within the domain of the initial URL.

## Features

### Required Functionality
- **Image Extraction**: Parse the given URL to identify and extract all image URLs present on the web page.
- **Sub-page Crawling**: Navigate through sub-pages linked from the initial page to find additional images.
- **Multi-threading**: Use multi-threading to crawl multiple sub-pages simultaneously, enhancing efficiency.
- **Domain Restriction**: Remain within the same domain as the initial URL, avoiding external sites.
- **Avoid Redundant Crawling**: Track visited pages to prevent redundant crawling.



## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven

### Installing
1. **Clone the Repository**
    ```sh
    git clone https://github.com/your-username/ImageFinder.git
    cd ImageFinder
    ```
2. **Install Dependencies**
    ```sh
    mvn install
    ```

### Running the Crawler
1. **Build the Project**
    ```sh
    mvn package
    ```
2. **Run the Project**
    ```sh
   mvn clean test package jetty:run"
    ```
  You should see a line at the bottom that says "Started Jetty Server". Now, if you enter `localhost:8080` into your browser, you should see the `index.html` welcome page! 
## Usage

1. **Input the URL**
   - Enter the URL of the web page you want to crawl for images.
2. **View Results**
   - You have two buttons:
   - 1.Get Images - The crawler will display all images found on the page and its sub-pages.
   - 2.Get ImageURLs - The crawler will display JSON array of image URLs found on the page and its sub-pages.


