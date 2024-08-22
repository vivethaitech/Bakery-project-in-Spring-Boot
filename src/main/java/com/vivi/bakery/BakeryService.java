package com.vivi.bakery;

import java.util.Collections;
import java.util.Comparator;
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
		List<Bakery> b = repo.findAll();
		Collections.sort(b,new Comparator<Bakery>(){

			@Override
			public int compare(Bakery b1, Bakery b2) {
				
				return b2.getItemName().compareTo(b1.getItemName());
			}
			
		});
		return b;
	}

	public String postItemDetails(Bakery b)  {
		//CombinedException c = new CombinedException();
		List<Bakery> bake = repo.findAll();
		for(Bakery bb:bake) {
			if(bb.getItemName().equals(b.getItemName())) {
				throw new DuplicateException("This item name already exist");
			}
			if(b.getPrice()>2000) {
				throw new PriceHighException("This item price is too high. Please check one more time");
			}
			}
		repo.save(b);
		return "Item details successfully added";
		}
		
	
		
    public String updateItemDetails(String name,int price) {
    	List<Bakery> bake = repo.findAll();
    	for(Bakery b:bake) {
    		if(b.getItemName().equals(name)) {
    			b.setPrice(price);
    			repo.save(b);
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
