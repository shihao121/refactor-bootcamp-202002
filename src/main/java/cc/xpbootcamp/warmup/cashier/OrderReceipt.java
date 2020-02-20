package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.utils.DateUtil;

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
                DateUtil.ofWeek(order.getDate()) +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getGoodsDetails() {
        StringBuilder output = new StringBuilder();
        for (Good good : order.getGoods()) {
            output.append(good.generateReceiptContent());
        }
        output.append(ReceiptConstant.SEPARATING_LINE);
        output.append(getOrderSummary());
        return output.toString();
    }

    private String getOrderSummary() {
        return getSalesTax() +
                getDiscountPrice() +
                getTotalAmount();
    }

    private String getDiscountPrice() {
        if (order.getAccountPrice() > 0){
            return ReceiptConstant.DISCOUNT_TOPIC +
                    ReceiptConstant.COLON_CHARACTER + order.getAccountPrice() +
                    ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
        }
        return "";
    }

    private String getTotalAmount() {
        return ReceiptConstant.TOTAL_AMOUNT_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.getTotalAmount() +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getSalesTax() {
        return ReceiptConstant.SALES_TAX_TOPIC +
                ReceiptConstant.COLON_CHARACTER + order.getTotalSalesTax() +
                ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
    }

    private String getCustomerInfo() {
        return order.getCustomerName() +
                order.getCustomerAddress();
    }
}
