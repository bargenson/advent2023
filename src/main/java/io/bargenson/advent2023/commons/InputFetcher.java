package io.bargenson.advent2023.commons;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InputFetcher {

    private HttpClient newHttpClient;

    public InputFetcher() {
        newHttpClient = HttpClient.newHttpClient();
    }

    public String fetch(String filePath) throws IOException, InterruptedException {
        HttpResponse<String> response = newHttpClient.send(
            HttpRequest.newBuilder(URI.create(filePath)).GET().build(),
            HttpResponse.BodyHandlers.ofString()
        );
        return response.body();
    }
}
