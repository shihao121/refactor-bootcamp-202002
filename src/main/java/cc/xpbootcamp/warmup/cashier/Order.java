package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Order {
    String customerName;
    String address;
    List<Good> goods;
    LocalDate date;

    public Order(String customerName, String address, List<Good> goods) {
        this.customerName = customerName;
        this.address = address;
        this.goods = goods;
    }

    public Order(String customerName, String address, List<Good> goods, LocalDate date) {
        this.customerName = customerName;
        this.address = address;
        this.goods = goods;
        this.date = date;
    }

    double getTotalSalesTax() {
        return goods.stream().mapToDouble(Good::getSalesTax).sum();
    }

    double getTotalAmount() {
        return goods.stream().mapToDouble(good -> good.getSalesTax() + good.totalAmount()).sum() - getAccountPrice();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getAccountPrice() {
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return goods.stream().mapToDouble(good -> good.getSalesTax() + good.totalAmount()).sum() * 0.02;
        }
        return 0;
    }
}
