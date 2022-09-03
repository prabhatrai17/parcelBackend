package com.deliver.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.Repository.ItemRepository;
import com.deliver.Service.ItemService;
import com.deliver.entities.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
		
	}

	@Override
	public Optional<Item> getItem(int id) {
		return itemRepository.findById(id);
		
	}
	

}
