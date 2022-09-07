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
		order.setOrderDate((dateTimeObj.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))).toString());
		System.out.println("order after date set: " + order);
		System.out.println("mail: " + mail);
		// user id fetched
		Integer id = userRepository.findUserIdByEmail(mail);
		System.out.println(id);
		user.setId(id);
		// user added to order
		order.setUser(user);
		System.out.println("order after id set: " + order);
		order.setPickupAddress(fOrder.getPickupAddress());
		order.setDropAddress(fOrder.getDropAddress());
		order.setEstDistance(fOrder.getEstDistance());
		order.setEstCost(fOrder.getEstCost());
		order.setArrivingStatus(fOrder.getArrivingStatus());
		order.setDeliveryStatus(fOrder.getDeliveryStatus());
		order.setDispatchStatus(fOrder.getDispatchStatus());
		order.setPickupStatus(fOrder.getPickupStatus());
		order.setPaymentStatus(fOrder.getPaymentStatus());
		
		return orderRepository.save(order);

	}

	public String statusUpdate(FullOrderObj ob, int orderId) {
		
		double prevRevenue=vehicleService.getVehicleRevenueByOrderId(orderId);
		double cost=ob.getEstCost();
		double revenue=cost*15/100+prevRevenue;
		vehicleService.changeVehicle(revenue,orderId);
		
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
	
	public String setDriverUserId(int driverUserId,int orderId){
		Integer res=orderRepository.setDriverUserId(driverUserId,orderId);
		System.out.println("result after driverUserID seted " + res);
		if (res == null)
			return "fail";
		else {
			return "pass";
		}
	}
	//update payment to true 
	public String updatePayment(int orderId){
		String s="true";
		Integer res=orderRepository.updatePaymentStatus(orderId,s);
		System.out.println("result after payment set true " + res);
		if (res == null)
			return "fail";
		else {
			return "pass";
		}
	}
	//gets total rev gen by driver
   public double getRevenueGenByDriver(int driverId) {
	   List<Order> orders= orderRepository.getOrdersByDriver(driverId);
	   double totalRevenue=0;
	   double totalAmount=0;
	   for( Order order:orders) {
		   totalAmount=totalAmount+order.getEstCost();
	   }
	   totalRevenue=totalAmount*15/100;
	   return totalRevenue;
	   
	   
   }
   //gets revenue gen acc.to no. of days
   public double getRevenueGenByDriverFilterDays(int driverId,String date1,String date2) {
	   System.out.println("date1 "+date1);
	   System.out.println("date2 "+date2);
	   List<Order> orders= orderRepository.getRevenueGenByDriverFilterDays(date1,date2,driverId);
	   
//System.out.println(orderRepository.getRevenueGenByDriverFilterDays(driverId,date1,date2));
	   System.out.println(orders);
	   double totalRevenue=0;
	   double totalAmount=0;
	   for( Order order:orders) {
		   totalAmount=totalAmount+order.getEstCost();
	   }
	   totalRevenue=totalAmount*15/100;
	   return totalRevenue;
	   
	   
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
