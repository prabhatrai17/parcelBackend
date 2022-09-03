package com.deliver.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.Service.ItemService;
import com.deliver.Service.OrderService;
import com.deliver.entities.FullOrderObj;
import com.deliver.entities.Item;
import com.deliver.entities.Order;
import com.deliver.entities.User;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ItemService itemService;
	
@PostMapping("/place_order")	
Item createOrder(@RequestBody FullOrderObj fOrder) {
	Item item=fOrder.getItem();
	User user=fOrder.getUser();

//	String mail="prabhatrai392@gmail.com";
	String mail=fOrder.getUser().getEmail();
	System.out.println("inside create order");
	System.out.println("full order recieved from frontend "+fOrder);
	System.out.println("item recieved from frontend "+item);
	System.out.println("user recieved from frontend "+user);
	//creating order with userId as foreign key
	Order orderSaved=orderService.createOrder( mail,user,fOrder);
	System.out.println("order save : "+orderSaved);
	//item attached with orderId as foreign key
	item.setOrder(orderSaved);
	//now item is saved
	Item itemSaved=itemService.createItem(item);
	System.out.println(itemSaved);
	return itemSaved;//casually returning item
}

@PostMapping("/status-update/{orderId}")	
boolean createOrder(@RequestBody FullOrderObj fOrder, @PathVariable int orderId) {
//	orderId=6;
//	fOrder.setUser(null);
//	fOrder.setItem(null);
	System.out.println(fOrder);
   if( orderService.statusUpdate(fOrder, orderId)=="pass")
	   return true;
   else return false;
}
@GetMapping("/order/{orderId}")
Optional<Order> getOneOrder(@PathVariable int orderId) {
	return orderService.getOrder(orderId);
}


@RequestMapping(value = "/orders/{userId}", method = RequestMethod.GET)
List<Order> getAllOrdersByUserId(@PathVariable int userId) {	
System.out.println("inside gelAllOrders by userid"+userId);
	
return orderService.getAllOrdersByUserId(userId);

}

@RequestMapping(value = "/orders", method = RequestMethod.GET)
List<Order> getAllOrders() {	
System.out.println("inside gelAllOrders");
	
return orderService.getAllOrders();

}
}
