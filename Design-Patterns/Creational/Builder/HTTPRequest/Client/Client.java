package Creational.Builder.HTTPRequest.Client;


import Builder.HTTPRequest.Product.HttpRequest;
import Builder.HTTPRequest.Product.HttpRequestBuilder;

public class Client {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequestBuilder()
                .method("POST")
                .url("/users")
                .headers("Authorization", "Bearer xxx")
                .headers("Content-Type", "application/json")
                .queryParameters("active", "true")
                .body("{\"name\":\"Walid\"}")
                .timeout(5000)
                .build();

        request.show();
    }
}
