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

@RestController
public class BakeryController {
	
	private BakeryService service;
	
	@Autowired
	public BakeryController(BakeryService service) {
		this.service=service;
	}
	
	@GetMapping("/bakery/read")
	public List<Bakery> getItemDetails(){
		return service.getItemDetails();
	}
	
	@PostMapping("/bakery/add")
	public String PostItemDetails(@RequestBody Bakery b) {
		return service.postItemDetails(b);
	}
	
    @PutMapping("bakery/update/{itemName}")
    public String updateItemDetails(@PathVariable String itemName, @RequestBody Bakery b) {
    	return service.updateItemDetails(itemName, b);
    }
	
	@DeleteMapping("/bakery/delete/{itemName}")
	public String deleteItemDetails(@PathVariable String itemName) {
		return service.deleteItemDetails(itemName);
	}
}
