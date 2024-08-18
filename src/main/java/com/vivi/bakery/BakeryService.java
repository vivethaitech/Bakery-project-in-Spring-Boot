package com.vivi.bakery;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BakeryService {
	private BakeryRepo repo;
	
	@Autowired
	public BakeryService(BakeryRepo repo) {
		this.repo=repo;
	}

	public List<Bakery> getItemDetails() {	
		return repo.findAll();
	}

	public String postItemDetails(Bakery b) {
		repo.save(b);
		return "Item details successfully added";
	}
		
    public String updateItemDetails(String name,Bakery b) {
    	List<Bakery> bake = repo.findAll();
    	for(Bakery bb:bake) {
    		if(bb.getItemName().equals(name)) {
    			bb.setItemName(b.getItemName());
    			bb.setPrice(b.getPrice());
    			bb.setStock(b.getStock());
    			return "Item successfully updated";
    		}
    	}
    	return "Item not found to update";
    }
      
	public String deleteItemDetails(String itemName) {
		List<Bakery> bake = repo.findAll();
	
		for(Bakery b: bake) {
			if(b.getItemName().equals(itemName)) {
				repo.deleteById(b.getItemId());
				return "Item deleted successfully";
			}
		}
		
		return "Sorry, Item not found to delete";
	}
}
