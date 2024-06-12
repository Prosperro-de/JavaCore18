package org.example.module11.stream.util;

import lombok.experimental.UtilityClass;
import org.example.module11.stream.util.model.Customer;
import org.example.module11.stream.util.model.Order;
import org.example.module11.stream.util.model.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.example.module11.stream.util.model.OrderStatus.COMPLETED;
import static org.example.module11.stream.util.model.OrderStatus.IN_PROGRESS;
import static org.example.module11.stream.util.model.OrderStatus.CREATED;

@UtilityClass
public class OrderGenerator {

    public static List<Order> generateOrders(int amount) {
        Random random = new Random();
        return IntStream.range(0, amount)
                .mapToObj(i -> {
                    int customerNumber = random.nextInt(1, 20);
                    return Order.builder()
                            .orderId((long) i)
                            .orderedAt(LocalDateTime.now().minusDays(random.nextInt(0, 30)))
                            .orderStatus(random.nextInt(0, 3) == 0 ? CREATED : (i % 3 == 1 ? IN_PROGRESS : COMPLETED))
                            .customer(Customer.builder()
                                    .name("Customer " + customerNumber)
                                    .email("customer" + customerNumber + "@example.com")
                                    .build())
                            .orderItems(List.of(
                                    OrderItem.builder()
                                            .productName("Product " + i)
                                            .quantity(random.nextInt(1, 10))
                                            .price(BigDecimal.valueOf(10.0 * random.nextInt(1, 20)))
                                            .build()))
                            .build();
                })
                .toList();
    }
}