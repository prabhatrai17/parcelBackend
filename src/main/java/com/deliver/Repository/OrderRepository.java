package com.deliver.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.deliver.entities.FullOrderObj;
import com.deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>  {
	@Query(value="select * from orders where user_id=?1",nativeQuery=true)
	List<Order> userAllOrdersByUserId( int userId);
	@Query(value="select * from orders where order_id=?1",nativeQuery=true)
	Order driverAssignedOrder( int orderId);
	@Modifying()
	@Transactional
	@Query(value="update orders SET arriving_status = ?1,delivery_status = ?2,dispatch_status = ?3,pickup_status = ?4 WHERE order_id = ?5",nativeQuery=true)
	Integer statusUpdate(String arrivingStatus,String deliveryStatus,String dispatchStatus,String pickupStatus,int orderId);
}
