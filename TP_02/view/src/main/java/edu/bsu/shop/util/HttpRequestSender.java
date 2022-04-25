package edu.bsu.shop.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsu.shop.exception.ServerException;
import edu.bsu.shop.exception.ViewRenderException;
import edu.bsu.shop.model.Order;
import edu.bsu.shop.model.Product;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;

public final class HttpRequestSender {

    private HttpRequestSender(){}

    public static Order[] getAllOrders() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/orders")
                .method("GET", null)
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                return objectMapper.readValue(responseBody.string(), Order[].class);
            } else {
                throw new ServerException();
            }
        } catch (IOException e) {
            throw new ViewRenderException();
        }
    }

    public static Product[] getAllProducts() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/products")
                .method("GET", null)
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                return objectMapper.readValue(responseBody.string(), Product[].class);
            } else {
                throw new ServerException();
            }
        } catch (IOException e) {
            throw new ViewRenderException();
        }
    }

    public static Order[] getUserOrders(Long userId) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/orders/users/" + userId)
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            ObjectMapper objectMapper = new ObjectMapper();
            if (responseBody != null) {
                return objectMapper.readValue(responseBody.string(), Order[].class);
            } else {
                throw new ServerException();
            }
        } catch (IOException e) {
            throw new ViewRenderException();
        }
    }
}
