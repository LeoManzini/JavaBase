package br.com.leomanzini.exercise.three;

public class OrderItem {
	
	private int quantity;
	private double price;
	
	private Product product;
	
	public OrderItem() {
	}
	
	public OrderItem(int quantity, double price, Product product) {
		setQuantity(quantity);
		setPrice(price);
		setProducts(product);
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProducts() {
		return product;
	}

	public void setProducts(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return product.getName() 
				+ ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
}
