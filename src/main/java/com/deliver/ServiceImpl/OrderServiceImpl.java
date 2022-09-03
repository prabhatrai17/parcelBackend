package com.deliver.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deliver.Repository.ItemRepository;
import com.deliver.Repository.OrderRepository;
import com.deliver.Repository.UserRepository;
import com.deliver.Service.OrderService;
import com.deliver.Service.VehicleService;
import com.deliver.entities.FullOrderObj;
import com.deliver.entities.Item;
import com.deliver.entities.Order;
import com.deliver.entities.User;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	VehicleService vehicleService;

	@Override
	public Order createOrder(String mail, User user, FullOrderObj fOrder) {
		
		

		Order order = new Order();
		order.setOrderCompleted("false");
		LocalDateTime dateTimeObj = LocalDateTime.now();
		order.setOrderDate((dateTimeObj.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))).toString());
		System.out.println("order after date set: " + order);
		System.out.println("mail: " + mail);
		// user id fetched
		Integer id = userRepository.findUserIdByEmail(mail);
		System.out.println(id);
		user.setId(id);
		// user added to order
		order.setUser(user);
		System.out.println("order after id set: " + order);
		order.setArrivingStatus(fOrder.getArrivingStatus());
		order.setDeliveryStatus(fOrder.getDeliveryStatus());
		order.setDispatchStatus(fOrder.getDispatchStatus());
		order.setPickupStatus(fOrder.getPickupStatus());
		
		return orderRepository.save(order);

	}

	public String statusUpdate(FullOrderObj ob, int orderId) {
		//vehicleService.changeVehicle(orderId);
		
		System.out.println(ob);
		String arrivingStatus = ob.getArrivingStatus();
		String pickupStatus = ob.getPickupStatus();
		String dispatchStatus = ob.getDispatchStatus();
		String deliveryStatus = ob.getDeliveryStatus();
		System.out.println(
				arrivingStatus + " " + deliveryStatus + " " + dispatchStatus + " " + pickupStatus + " " + orderId);

		Integer res = orderRepository.statusUpdate(arrivingStatus, deliveryStatus, dispatchStatus, pickupStatus,
				orderId);
		System.out.println("res " + res);
		if (res == null)
			return "fail";
		else {
			return "pass";
		}

	}

	@Override
	public Optional<Order> getOrder(int id) {
		Integer orderId = id;
		return orderRepository.findById(orderId);

	}

	public List<Order> getAllOrdersByUserId(Integer userId) {
		System.out.println("inside all order by user repo: " + userId);
//		 System.out.println(orderRepository.findAll());
		return orderRepository.userAllOrdersByUserId(userId);
	}

	public List<Order> getAllOrders() {
		System.out.println("inside all order repo: ");
//		 System.out.println(orderRepository.findAll());
		return orderRepository.findAll();
	}

	public Order driverAssignedOrder(Integer orderId) {
		System.out.println("inside all order repo: " + orderId);
//		 System.out.println(orderRepository.findAll());
		return orderRepository.driverAssignedOrder(orderId);
	}

}
