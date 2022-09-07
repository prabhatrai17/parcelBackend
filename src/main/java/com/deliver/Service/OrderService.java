package com.deliver.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.deliver.entities.FullOrderObj;
import com.deliver.entities.Order;
import com.deliver.entities.User;

public interface OrderService {
	Order createOrder(String mail,User user,FullOrderObj fOrder);
	Optional<Order>  getOrder(int id);
	List<Order>  getAllOrdersByUserId(Integer userId);
	List<Order> getAllOrders();
	Order driverAssignedOrder(Integer orderId);
	String statusUpdate(FullOrderObj ob,int orderId);
	String setDriverUserId(int driverUserId, int orderId);
	String updatePayment(int orderId);
	public double getRevenueGenByDriver(int driverId);
	public double getRevenueGenByDriverFilterDays(int driverId,String date1,String date2);

} 
