package com.deliver.Repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deliver.entities.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {
	@Query(value="select revenue_generated from final_parcel.vehicle_data where order_id=?1",nativeQuery=true)
	double getVehicleRevenueByOrderId(int orderId);
	@Query(value="select * from final_parcel.vehicle_data where driver_user_id=?1 and order_id=?2 ",nativeQuery=true)
	Vehicle findByOrderId( int userId,int orderId);
	@Query(value="select * from final_parcel.vehicle_data where driver_user_id=?1",nativeQuery=true)
	Vehicle findByDriverUserId(int DriverUserId);
	@Query(value="select revenue_generated from final_parcel.vehicle_data where driver_user_id=?1",nativeQuery=true)
	double getVehicleRev(int driverId);
	@Modifying
	@Transactional
	@Query(value="update vehicle_data set revenue_generated=?1, vehicle_availability=true where order_id=?2",nativeQuery=true)
	Integer changeVehicle(double revenueGen,int orderId);
	@Query(value="select * from final_parcel.vehicle_data where vehicle_availability=true",nativeQuery=true)
	List<Vehicle>  findAllAvailableVehicles();
	@Query(value="select order_id from final_parcel.vehicle_data where driver_user_id=?1",nativeQuery=true)
	List<Integer> getDriverAssignedOrderIds(int userId);
}
