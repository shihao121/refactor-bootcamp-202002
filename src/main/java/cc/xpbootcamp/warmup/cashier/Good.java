package cc.xpbootcamp.warmup.cashier;

public class Good {
	private String desc;
	private double price;
	private int quantity;

	public Good(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public double getSalesTax() {
		return totalAmount() * .10;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	String generateReceiptContent() {
		return getDescription() + ReceiptConstant.SEPARATOR_CHARACTER
				+ getPrice() + ReceiptConstant.MULTIPLY_CHARACTER
				+ getQuantity() + ReceiptConstant.SEPARATOR_CHARACTER
				+ totalAmount() + ReceiptConstant.NEW_LINE_ESCAPE_SEQUENCES;
	}
}
