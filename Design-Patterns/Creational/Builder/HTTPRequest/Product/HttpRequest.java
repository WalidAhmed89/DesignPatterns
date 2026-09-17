package Creational.Builder.HTTPRequest.Product;

import java.util.Map;

public class HttpRequest {
    private final String URL;
    private final String httpMethod;
    private final Map<String, String> headers;
    private final Map<String, String> query;
    private final String body;
    private final int timeout;

    public HttpRequest(
            String httpMethod,
            String URL,
            Map<String, String> headers,
            Map<String, String> query,
            String body,
            int timeout
    ) {
        this.URL = URL;
        this.httpMethod = httpMethod;
        this.headers = headers;
        this.query = query;
        this.body = body;
        this.timeout = timeout;
    }


    public void show() {
        System.out.println("HTTP Method: " + httpMethod);
        System.out.println("URL: " + URL);

        System.out.println("Headers: \n");
        headers.forEach((key, value) -> System.out.println(" " + key + ": " + value + "\n"));

        System.out.println("Query: \n");
        query.forEach((key, value) -> System.out.println(" " + key + ": " + value + "\n"));

        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout);
    }
}
