package gof.behavioural.cor;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a very dumbed down version of how to represent a HttpResponse, actual implementations
 * such as in Spring Web or Express for Node.js is much more involved.
 */
@Getter
@Setter
public class HttpResponse {
    Map<String, String> headers = new HashMap<>();
    private String body;
    private String httpVersion;
    private int statusCode;

    public HttpResponse(String body, String httpVersion, int statusCode) {
        this.body = body;
        this.httpVersion = httpVersion;
        this.statusCode = statusCode;
    }
}
