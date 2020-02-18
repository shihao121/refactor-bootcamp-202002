package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return receiptHeader() +
                getCustomerInfo() +
                getGoodsDetails();
    }

    private String getGoodsDetails() {
        StringBuilder output = new StringBuilder();
        for (Good good : order.getGoods()) {
            output.append(getGoodDetails(good));
        }
        output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());
        output.append("Total Amount").append('\t').append(order.getTotalAmount());
        return output.toString();
    }

    private String getGoodDetails(Good good) {
        return good.getDescription() + "\t"
                + good.getPrice() + "\t"
                + good.getQuantity() + "\t"
                + good.totalAmount() + "\n";
    }

    private String getCustomerInfo() {
        return order.getCustomerName() +
                order.getCustomerAddress();
    }

    private String receiptHeader() {
        return "======Printing Orders======\n";
    }

}
