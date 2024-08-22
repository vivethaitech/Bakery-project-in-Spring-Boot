package com.vivi.bakery;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class BakeryModel {
	@NotBlank(message="Name Strictly Required")
	private String itemName;
	
	@Max(value=2000,message="price should be minimum of 2000")
	private int price;
	
	@PositiveOrZero(message = "The stock count must be zero or a positive number.")
    private int stockCount;

	public BakeryModel(@NotBlank(message = "Name Strictly Required") String itemName,
			@Min(value = 2000, message = "price is must") int price,
			@PositiveOrZero(message = "The stock count must be zero or a positive number.") int stockCount) {
		this.itemName = itemName;
		this.price = price;
		this.stockCount = stockCount;
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

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	
	
	
	

}
