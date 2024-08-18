package com.vivi.bakery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BakeryService {
	private static final Logger logger = LoggerFactory.getLogger(BakeryService.class);
	
	List<Bakery> bake = new ArrayList<>();
	
	public List<Bakery> getItemDetails() {
		logger.info("Fetching all item details");
		return bake;
	}

	
	public String postItemDetails(Bakery b) {
		bake.add(b);
		logger.info("Added new item: {}", b);
		return "Item details successfully added";
	}
	

	public String postItemDetails(String itemName,int price) {
		for(Bakery b:bake) {
			if (b.getItemName().equalsIgnoreCase(itemName)) { 
				b.setPrice(price);
				return "price updated Successfully";
			}
		}
		logger.warn("Item not found: ", itemName);
		return "Sorry, Item not found to change the price";
	}
	
	
	public String deleteItemDetails(String itemName) {
		for(Bakery b:bake) {
			if(b.getItemName().equals(itemName)) {
				bake.remove(b);
				return "Item deleted successfully";
			}
		}
		logger.warn("Item not found: ", itemName);
		return "Sorry, Item not found to delete";
	}
}
