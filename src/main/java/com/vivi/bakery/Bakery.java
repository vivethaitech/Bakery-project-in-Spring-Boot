package com.vivi.bakery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bakery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long itemId;
	private String itemName;
	private int price;
	private int stock;
	
	public Bakery() {
	}

	
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
	
	
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Bakery[itemName="+itemName+", price="+price+", stock="+stock+"]";	
	}
}
