package com.vivi.bakery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class BakeryController {
	
	private BakeryService service;
	private GroceryShop gs;
	
	@Autowired
	public BakeryController(BakeryService service, GroceryShop gs) {
		this.service=service;
		this.gs=gs;
	}

	@GetMapping("/bakery/read")
	public List<Bakery> getItemDetails(){
		return service.getItemDetails();
	}
	
	@PostMapping("/bakery/add")
	public String PostItemDetails(@RequestBody @Valid BakeryModel bm) {
		Bakery b = new Bakery(bm.getItemName(),bm.getPrice(),bm.getStockCount());
		return service.postItemDetails(b);
	}
	
    @PutMapping("bakery/update/{itemName}")
    public String updateItemDetails(@PathVariable String itemName, @RequestParam int price) {
    	return service.updateItemDetails(itemName, price);
    }
	
	@DeleteMapping("/bakery/delete/{itemName}")
	public String deleteItemDetails(@PathVariable String itemName) {
		return service.deleteItemDetails(itemName);
	}
    @GetMapping("/grocery/message")
    public String getGroceryMessage() {
        return gs.getMessage();
    }
	
}
