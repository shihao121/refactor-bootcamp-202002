package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<Good> goods;

    public Order(String customerName, String address, List<Good> goods) {
        this.customerName = customerName;
        this.address = address;
        this.goods = goods;
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
}
