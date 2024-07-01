package org.example.module13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.module13.httpdemo.request.CreateCustomerRequestDto;
import org.example.module13.httpdemo.request.CreateOrderItemRequestDto;
import org.example.module13.httpdemo.request.CreateOrderRequestDto;
import org.example.module13.httpdemo.response.CustomerResponseDto;
import org.example.module13.httpdemo.response.OrderResponseDto;
import org.example.module13.httpdemo.response.ProductResponseDto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Demo {
    private static final String BASE_URL = "http://localhost:8080";
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        HttpClient httpClient = HttpClient.newHttpClient();

//        HttpRequest productsRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/products"))
//                .GET()
//                .build();
//
//        HttpResponse<String> stringResponse = httpClient.send(productsRequest, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println("stringResponse.statusCode() = " + stringResponse.statusCode());
//        List<ProductResponseDto> responseDtos = objectMapper.readValue(stringResponse.body(),
//                objectMapper.getTypeFactory().constructCollectionType(List.class, ProductResponseDto.class));
//        responseDtos.forEach(System.out::println);

        // TODO: create new customer
        CreateCustomerRequestDto customerRequest = CreateCustomerRequestDto.builder()
                .name("Mykola")
                .country("UA")
                .city("Dnipro")
                .postalCode("49000")
                .phone("555-555")
                .address("Main-street")
                .build();
        String customerRequestJson = objectMapper.writeValueAsString(customerRequest);

        HttpRequest createCustomerHttpRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/customer"))
                .POST(HttpRequest.BodyPublishers.ofString(customerRequestJson))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> createCustomerResponse =
                httpClient.send(createCustomerHttpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("createCustomerResponse.statusCode() = " + createCustomerResponse.statusCode());

        CustomerResponseDto customerResponseDto = objectMapper.readValue(createCustomerResponse.body(), CustomerResponseDto.class);
        System.out.println("customerResponseDto = " + customerResponseDto);


        //TODO: create order for the customer

        CreateOrderRequestDto orderRequestDto = CreateOrderRequestDto.builder()
                .customerId(customerResponseDto.id())
                .items(List.of(
                        CreateOrderItemRequestDto.builder()
                                .productId(1L)
                                .quantity(3)
                                .build(),
                        CreateOrderItemRequestDto.builder()
                                .productId(5L)
                                .quantity(2)
                                .build(),
                        CreateOrderItemRequestDto.builder()
                                .productId(2L)
                                .quantity(6)
                                .build(),
                        CreateOrderItemRequestDto.builder()
                                .productId(7L)
                                .quantity(7)
                                .build()))
                .build();
        String orderRequestJson = objectMapper.writeValueAsString(orderRequestDto);
        HttpRequest createOrderRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/order"))
                .POST(HttpRequest.BodyPublishers.ofString(orderRequestJson))
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> orderResponse = httpClient.send(createOrderRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("orderResponse.statusCode() = " + orderResponse.statusCode());
        OrderResponseDto orderResponseDto = objectMapper.readValue(orderResponse.body(), OrderResponseDto.class);
        System.out.println("orderResponseDto = " + orderResponseDto);
    }
}
