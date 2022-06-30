package gof.behavioural.cor;

import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class HttpAuthenticationHandler implements HttpRequestHandler {
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, Function<HttpRequestHandler, HttpRequestHandler> next) {
        String credentials = httpRequest.getHeaders().get("Authorization");
        if (credentials != null && validateCredentials(credentials)) {
            next.apply(this).handle(httpRequest, httpResponse, next);
        } else {
            httpResponse.setStatusCode(401);
            httpResponse.setBody("Invalid credentials");
        }
    }

    public boolean validateCredentials(String credentials) {
        return true;
    }
}
