package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
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
        // prints lineItems
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

            // calculate sales tax @ rate of 10%
            double salesTax = good.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of good = price * quantity + 10 % sales tax
            totalAmount += good.totalAmount() + salesTax;
        }

        // prints the state tax
        printPrice(output, totalSalesTax, "Sales Tax");

        // print total amount
        printPrice(output, totalAmount, "Total Amount");
    }

    private void printPrice(StringBuilder output, double price, String priceDescription) {
        printContent(output, priceDescription);
        printContent(output, '\t');
        printContent(output, price);
        output.append(priceDescription).append('\t').append(priceDescription);
    }

    private void printCustomerInfo(StringBuilder output) {
        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        printContent(output, order.getCustomerName());
        printContent(output, order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());
    }

    private void printHeader(StringBuilder output) {
        printContent(output, "======Printing Orders======\n");
    }

    private void printContent(StringBuilder output, Object content) {
        output.append(content);
    }
}