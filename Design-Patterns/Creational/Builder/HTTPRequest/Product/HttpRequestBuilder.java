package Creational.Builder.HTTPRequest.Product;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestBuilder {
    private String method;
    private String url;

    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> queryParameters = new HashMap<>();

    private String body;
    private int timeout = 3000;

    public HttpRequestBuilder method(String method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public HttpRequestBuilder headers(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public HttpRequestBuilder queryParameters(String key, String value) {
        queryParameters.put(key, value);
        return this;
    }

    public HttpRequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder timeout(int timeout) {
        if (timeout <= 0) {
            throw new IllegalArgumentException(
                    "Timeout must be greater than 0"
            );
        }
        this.timeout = timeout;
        return this;
    }

    public HttpRequest build() {

        if (method == null || method.isBlank()) {
            throw new IllegalStateException(
                    "HTTP Request is required"
            );
        }

        if (url == null || url.isBlank()) {
            throw new IllegalStateException(
                    "URL is required"
            );
        }
        return new HttpRequest(
                method,
                url,
                new HashMap<>(headers),
                new HashMap<>(queryParameters),
                body,
                timeout
        );
    }
}



