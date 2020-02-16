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
            printGoodDetails(output, good);
            double salesTax = good.totalAmount() * .10;
            totalSalesTax += salesTax;
            totalAmount += good.totalAmount() + salesTax;
        }
        printPrice(output, totalSalesTax, "Sales Tax");
        printPrice(output, totalAmount, "Total Amount");
    }

    private void printGoodDetails(StringBuilder output, Good good) {
        printContent(output, good.getDescription());
        printFourTimesSpacebar(output);
        printContent(output, good.getPrice());
        printFourTimesSpacebar(output);
        printContent(output, good.getQuantity());
        printFourTimesSpacebar(output);
        printContent(output, good.totalAmount());
        printInNewLine(output);
    }

    private void printInNewLine(StringBuilder output) {
        printSpecifyContent(output, '\n');
    }

    private void printFourTimesSpacebar(StringBuilder output) {
        printSpecifyContent(output, '\t');
    }

    private void printSpecifyContent(StringBuilder output, char escapeSequence) {
        output.append(escapeSequence);
    }

    private void printPrice(StringBuilder output, double price, String priceDescription) {
        printContent(output, priceDescription);
        printFourTimesSpacebar(output);
        printContent(output, price);
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