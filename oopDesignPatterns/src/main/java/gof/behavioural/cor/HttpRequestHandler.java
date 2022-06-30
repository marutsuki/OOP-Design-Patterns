package gof.behavioural.cor;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface HttpRequestHandler {

    void handle(HttpRequest httpRequest, HttpResponse httpResponse, Function<HttpRequestHandler, HttpRequestHandler> next);
}
