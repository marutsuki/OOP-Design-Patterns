package gof.behavioural.cor;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class HttpVersionHandler implements HttpRequestHandler{
    private static final String HTTP_VERSION = "1.1";
    private static List<String> SUPPORTED_VERSIONS = List.of("1.0, 1.1, 2");
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, Function<HttpRequestHandler, HttpRequestHandler> next) {
        if (!SUPPORTED_VERSIONS.contains(httpRequest.getHttpVersion())) {
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Unsupported HTTP version");
        } else {
            httpResponse.setHttpVersion(HTTP_VERSION);
            next.apply(this).handle(httpRequest, httpResponse, next);
        }
    }
}
