package com.deliver.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deliver.entities.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {
	@Query(value="select * from final_parcel.vehicle_data where user_id=?1 and order_id=?2 ",nativeQuery=true)
	Vehicle findByOrderId( int userId,int orderId);
	@Query(value="select * from final_parcel.vehicle_data where user_id=?1",nativeQuery=true)
	Vehicle findByUserId(int userId);
	@Query(value="update vehicle_data set vehicle_availability=true where order_id=?1",nativeQuery=true)
	Vehicle changeVehicle(int orderId);
	@Query(value="select * from final_parcel.vehicle_data where vehicle_availability=true",nativeQuery=true)
	List<Vehicle>  findAllAvailableVehicles();
	@Query(value="select order_id from final_parcel.vehicle_data where user_id=?1",nativeQuery=true)
	List<Integer> getDriverAssignedOrderIds(int userId);
}
