package org.example.module8.enums;

public class Demo {

    static int attemptsCounter = 0;
    public static void main(String[] args) {
        Order macBook = new Order("Apple MacBook", ProductType.PREMIUM, OrderStatus.CREATION_IN_PROGRESS);
        Order thinkPad = new Order("Lenovo ThinkPad", ProductType.STANDARD, OrderStatus.CREATED);

//        System.out.println(OrderStatus.CREATION_IN_PROGRESS.isTerminatedStatus());
//        System.out.println(OrderStatus.CREATED.isTerminatedStatus());
//
//        for (OrderStatus value : OrderStatus.values()) {
//            System.out.println(value.name());
//        }
        processOrder(macBook);

    }

    public static void processOrder(Order order) {
        try {
            if (attemptsCounter >= 3) {
                order.setOrderStatus(OrderStatus.CREATED);
                System.out.println("Order successfully created");
            }
//            if (!order.getOrderStatus().equals(OrderStatus.CREATED)) {
            if (!OrderStatus.CREATED.equals(order.getOrderStatus())) {
                attemptsCounter++;
                System.out.println("We are still in progress");
                throw new RuntimeException();
            }
            System.out.println("order.getOrderStatus() = " + order.getOrderStatus().name());
        } catch (RuntimeException ex) {
            processOrder(order);
        }
    }
}
