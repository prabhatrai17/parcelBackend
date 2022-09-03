package com.deliver.Service;
import java.util.Optional;
import com.deliver.entities.Item;

public interface ItemService {
	
Item createItem(Item item);
Optional<Item> getItem(int id);
}
