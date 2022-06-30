package gof.behavioural.cor;

import lombok.AllArgsConstructor;

import java.util.function.BiConsumer;
import java.util.function.Function;

@AllArgsConstructor
public class HttpRouteHandler implements HttpRequestHandler {

    private BiConsumer<HttpRequest, HttpResponse> handler;
    private String route;
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, Function<HttpRequestHandler, HttpRequestHandler> next) {
        String route = httpRequest.getRequestPath();
        if (this.route.equals(route)) {
            handler.accept(httpRequest, httpResponse);
        } else {
            next.apply(this).handle(httpRequest, httpResponse, next);
        }
    }
}
