package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return ReceiptConstant.RECEIPT_HEADER +
                getCustomerInfo() +
                getGoodsDetails();
    }

    private String getGoodsDetails() {
        StringBuilder output = new StringBuilder();
        for (Good good : order.getGoods()) {
            output.append(good.generateReceiptContent());
        }
        output.append(ReceiptConstant.SEPARATING_LINE);
        output.append(getSalesTax());
        output.append(getTotalAmount());
        return output.toString();
    }

    private String getTotalAmount() {
        return ReceiptConstant.TOTAL_AMOUNT_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.getTotalAmount();
    }

    private String getSalesTax() {
        return ReceiptConstant.SALES_TAX_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.getTotalSalesTax();
    }

    private String getCustomerInfo() {
        return order.getCustomerName() +
                order.getCustomerAddress();
    }
}
