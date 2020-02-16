package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeader(output);
        printCustomerInfo(output);
        printGoodsDetails(output);
        return output.toString();
    }

    private void printGoodsDetails(StringBuilder output) {
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (Good good : order.getGoods()) {
            output.append(good.getDescription());
            output.append('\t');
            output.append(good.getPrice());
            output.append('\t');
            output.append(good.getQuantity());
            output.append('\t');
            output.append(good.totalAmount());
            output.append('\n');

            double salesTax = good.totalAmount() * .10;
            totalSalesTax += salesTax;

            totalAmount += good.totalAmount() + salesTax;
        }

        printPrice(output, totalSalesTax, "Sales Tax");

        printPrice(output, totalAmount, "Total Amount");
    }

    private void printPrice(StringBuilder output, double price, String priceDescription) {
        printContent(output, priceDescription);
        printContent(output, '\t');
        printContent(output, price);
        output.append(priceDescription).append('\t').append(priceDescription);
    }

    private void printCustomerInfo(StringBuilder output) {
        printContent(output, order.getCustomerName());
        printContent(output, order.getCustomerAddress());
    }

    private void printHeader(StringBuilder output) {
        printContent(output, "======Printing Orders======\n");
    }

    private void printContent(StringBuilder output, Object content) {
        output.append(content);
    }
}