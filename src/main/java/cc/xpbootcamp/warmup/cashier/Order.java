package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    public static final double DISCOUNT_PERCENTAGE = 0.02;
    List<OrderItem> orderItems;
    LocalDate date;

    public Order(List<OrderItem> orderItems, LocalDate date) {
        this.orderItems = orderItems;
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDate getDate() {
        return this.date;
    }

    double calculateTotalSalesTax() {
        return orderItems.stream().mapToDouble(OrderItem::getSalesTax).sum();
    }

    double calculateTotalAmount() {
        return calculateTotalAmountWithoutAcount() - calculateAccountPrice();
    }

    public double calculateAccountPrice() {
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return calculateTotalAmountWithoutAcount() * DISCOUNT_PERCENTAGE;
        }
        return 0;
    }

    private double calculateTotalAmountWithoutAcount() {
        return orderItems.stream().mapToDouble(orderItem -> orderItem.getSalesTax() + orderItem.totalAmount()).sum();
    }
}
