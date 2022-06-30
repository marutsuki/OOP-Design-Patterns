package gof.behavioural.cor;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class HelloWorldResponseHandler implements BiConsumer<HttpRequest, HttpResponse> {
    @Override
    public void accept(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.setStatusCode(200);
        httpResponse.setBody("Hello world");
    }
}
