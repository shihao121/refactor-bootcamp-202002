package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return ReceiptConstant.RECEIPT_HEADER +
                getDateInfo() +
                getGoodsDetails();
    }

    private String getDateInfo() {
        return order.getDate().format(ReceiptConstant.DATE_FORMATTER) +
                ReceiptConstant.SEPARATOR_CHARACTER +
                order.getDate().format(DateTimeFormatter.ofPattern("E", Locale.CHINESE)) +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getGoodsDetails() {
        StringBuilder output = new StringBuilder();
        for (OrderItem orderItem : order.getOrderItems()) {
            output.append(generateReceiptContent(orderItem));
        }
        output.append(ReceiptConstant.SEPARATING_LINE);
        output.append(getOrderSummary());
        return output.toString();
    }

    static String generateReceiptContent(OrderItem orderItem) {
        return orderItem.getDescription() + ReceiptConstant.SEPARATOR_CHARACTER
                + orderItem.getPrice() + ReceiptConstant.MULTIPLY_CHARACTER
                + orderItem.getQuantity() + ReceiptConstant.SEPARATOR_CHARACTER
                + orderItem.totalAmount() + ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getOrderSummary() {
        return getSalesTax() +
                getDiscountPrice() +
                getTotalAmount();
    }

    private String getDiscountPrice() {
        if (order.calculateAccountPrice() > 0){
            return ReceiptConstant.DISCOUNT_TOPIC +
                    ReceiptConstant.COLON_CHARACTER + order.calculateAccountPrice() +
                    ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
        }
        return "";
    }

    private String getTotalAmount() {
        return ReceiptConstant.TOTAL_AMOUNT_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.calculateTotalAmount() +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getSalesTax() {
        return ReceiptConstant.SALES_TAX_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.calculateTotalSalesTax() +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }
}
