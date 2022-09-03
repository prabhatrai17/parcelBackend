package com.deliver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deliver.entities.Order;


@Repository
public interface StatusRepository extends JpaRepository<Order,Integer>{
    
	@Query(value = "select pickup_status from final_parcel.orders where user_id = ?1 and order_id = ?2",nativeQuery=true)
	String getPickupQuery(Integer userId, Integer orderId);
	@Query(value = "select dispatch_status from final_parcel.orders where user_id = ?1 and order_id = ?2",nativeQuery=true)
	String getDispatchQuery(Integer userId, Integer orderId);
	@Query(value = "select arriving_status from final_parcel.orders where user_id = ?1 and order_id = ?2",nativeQuery=true)
	String getArrivingQuery(Integer userId, Integer orderId);
	@Query(value = "select delivery_status from final_parcel.orders where user_id = ?1 and order_id = ?2",nativeQuery=true)
	String getDeliveryQuery(Integer userId, Integer orderId);
	
}
