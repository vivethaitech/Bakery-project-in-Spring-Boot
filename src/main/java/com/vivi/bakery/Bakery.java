package com.vivi.bakery;

public class Bakery {
	
	private String itemName;
	private int price;
	private int stock;
	
	public Bakery(String itemName,int price,int stock) {
		this.itemName=itemName;
		this.price=price;
		this.stock=stock;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Bakery[itemName="+itemName+", price="+price+", stock="+stock+"]";	
	}
}
