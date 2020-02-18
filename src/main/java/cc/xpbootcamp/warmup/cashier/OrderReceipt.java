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
        double totalAmount = getTotalAmount();

        output.append("Sales Tax").append('\t').append(getTotalSalesTax());
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }

    private double getTotalAmount() {
        double totalAmount = 0d;
        for (Good good : order.getGoods()) {
            totalAmount += good.totalAmount() + good.getSalesTax();
        }
        return totalAmount;
    }

    private double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (Good good : order.getGoods()) {
            totalSalesTax += good.getSalesTax();
        }
        return totalSalesTax;
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
