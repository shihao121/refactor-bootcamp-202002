package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    String customerName;
    String address;
    List<OrderItem> orderItems;
    LocalDate date;

    public Order(String customerName, String address, List<OrderItem> orderItems, LocalDate date) {
        this.customerName = customerName;
        this.address = address;
        this.orderItems = orderItems;
        this.date = date;
    }

    double calculateTotalSalesTax() {
        return orderItems.stream().mapToDouble(OrderItem::getSalesTax).sum();
    }

    double calculateTotalAmount() {
        return calculateTotalAmountWithoutAcount() - calculateAccountPrice();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double calculateAccountPrice() {
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return calculateTotalAmountWithoutAcount() * 0.02;
        }
        return 0;
    }

    private double calculateTotalAmountWithoutAcount() {
        return orderItems.stream().mapToDouble(orderItem -> orderItem.getSalesTax() + orderItem.totalAmount()).sum();
    }
}
