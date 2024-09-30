package ru.yandex.practicum;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.HashMap;

public class TestHttp {
    HttpClient client = HttpClient.newHttpClient();
    URI uri = URI.create("https://jsonplaceholder.typicode.com/todos/1");
    HttpRequest.Builder request = HttpRequest.newBuilder();

    public TestHttp() throws IOException, InterruptedException, IllegalArgumentException {
        HttpRequest request  = this.request
                .GET()
                .uri(uri)
                .version(HttpClient.Version.HTTP_2)
                .header("Accept", "application/json")
                .build();


        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

        try {
            HttpResponse<String> response = client.send(request, handler);

            System.out.println(response.statusCode());
            System.out.println(response.body());

            JsonElement jsonElement = JsonParser.parseString(response.body());

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
            } else {
                JsonArray jsonArray = jsonElement.getAsJsonArray();
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("ERRORRRR");
        }

//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);
    }

    private String queryParamsToString(request) {
        String preparedString = "?";



        return preparedString;
    }
}

class ToDoQueryParamsRequest {
    Integer id;
    String description;
    Integer parentId;
}

class ToDoResponse {
    Integer id;
}
