package cc.xpbootcamp.warmup.cashier;

public class OrderItem {
	private String desc;
	private double price;
	private int quantity;

	public OrderItem(String desc, double price, int quantity) {
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

}
