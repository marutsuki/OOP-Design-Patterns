package gof.behavioural.cor;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a very dumbed down version of how to represent a HttpRequest, actual implementations
 * such as in Spring Web or Express for Node.js is much more involved.
 */
@Getter
public class HttpRequest {
    private Map<String, String> param = new HashMap<>();
    private Map<String, String> query = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    // Map for storing other properties
    private Map<String, String> properties = new HashMap<>();
    private HttpMethod method;
    private String body;
    private String httpVersion;
    private String requestPath;
    private int statusCode;

    public HttpRequest(HttpMethod method, String body, String httpVersion, String requestPath, int statusCode) {
        this.method = method;
        this.body = body;
        this.httpVersion = httpVersion;
        this.requestPath = requestPath;
        this.statusCode = statusCode;
    }
}
