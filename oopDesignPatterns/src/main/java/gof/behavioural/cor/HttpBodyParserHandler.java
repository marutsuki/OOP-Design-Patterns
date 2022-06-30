package gof.behavioural.cor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class HttpBodyParserHandler implements HttpRequestHandler {
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, Function<HttpRequestHandler, HttpRequestHandler> next) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            httpRequest.getProperties().putAll(objectMapper.readValue(httpRequest.getBody(), Map.class));
            next.apply(this).handle(httpRequest, httpResponse, next);
        } catch (JsonProcessingException e) {
            httpResponse.setStatusCode(400);
            httpResponse.setBody("Invalid body");
        }

    }
}
