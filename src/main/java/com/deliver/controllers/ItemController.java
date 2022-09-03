package com.deliver.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.Service.ItemService;
import com.deliver.entities.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item/{id}")
	Optional<Item> getItem(@PathVariable int id) {
		System.out.println("inside get item");
		System.out.println("id recieved from frontend "+id);
		return itemService.getItem(id);
	}
	
	@PostMapping("/add_item")
	Item createItem(@RequestBody Item item) {
		System.out.println("inside create item");
		System.out.println("item obj recieved from frontend "+item);
		return itemService.createItem(item);
	}

}
