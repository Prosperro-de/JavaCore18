package org.example.module11.stream;

import org.example.module11.stream.util.OrderGenerator;
import org.example.module11.stream.util.model.Customer;
import org.example.module11.stream.util.model.Order;
import org.example.module11.stream.util.model.OrderItem;
import org.example.module11.stream.util.model.OrderStatus;
import org.example.module9.CustomContainer;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoStreamProcessing {
    /*
    Intermediate operation

    filter(Predicate<T> predicate)
    map(Function<T, R> mapper)
    flatMap(Function<T, Stream<R>> mapper)
    distinct()
    sorted()
    sorted(Comparator<? super T> comparator)
    peek(Consumer<? super T> action)
    limit(long maxSize)
    skip(long n)
     */

    /*
    Terminal operators

    forEach(Consumer<? super T> action)
    forEachOrdered(Consumer<? super T> action)
    toArray()
    reduce(BinaryOperator<T> accumulator)
    collect(Collector<? super T,A,R> collector)
    min(Comparator<? super T> comparator)
    max(Comparator<? super T> comparator)
    count()
    anyMatch(Predicate<? super T> predicate)
    allMatch(Predicate<? super T> predicate)
    noneMatch(Predicate<? super T> predicate)
    findFirst()
    findAny()
     */
    public static void main(String[] args) {
        List<Order> orders = OrderGenerator.generateOrders(20);

        List<Order> completedOrders = orders.stream()
                .filter(order -> OrderStatus.COMPLETED.equals(order.getOrderStatus()))
                .toList();

//        Map<Customer, Order> customerOrderMap = orders.stream()
//                .filter(order -> OrderStatus.COMPLETED.equals(order.getOrderStatus()))
//                .collect(Collectors.toMap(Order::getCustomer, Function.identity())); // doesn't work with multiple orders
        Map<Customer, List<Order>> customerListMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        Map<Boolean, List<Order>> partitionedMap = orders.stream()
                .collect(Collectors.partitioningBy(order -> OrderStatus.IN_PROGRESS.equals(order.getOrderStatus())));

        BigDecimal orderPrices = orders.stream()
//                .map(order -> order.getOrderItems()) //Stream<Order>
                .flatMap(order -> order.getOrderItems().stream())
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order anyCompletedOrder = orders.stream()
                .filter(order -> OrderStatus.COMPLETED.equals(order.getOrderStatus()))
                .findFirst()
                .orElseThrow();

        Order max = orders.stream()
                .max(
                        Comparator.comparing(order -> order.getOrderItems().stream()
                                .map(OrderItem::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .orElseThrow();

        CustomContainer<Object> customContainer = orders.stream()
                .filter(order -> OrderStatus.COMPLETED.equals(order.getOrderStatus()))
                .collect(Collector.of(
                        CustomContainer::new,
                        CustomContainer::add,
                        (x, y) -> x
                ));

        String s = "";
    }
}
