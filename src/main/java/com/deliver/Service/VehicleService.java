package com.deliver.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliver.entities.Vehicle;
import com.deliver.Repository.UserRepository;
import com.deliver.Repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	

	public Vehicle addVehicle(Vehicle vehicle) {
		return repository.save(vehicle);
	}
	public Vehicle changeVehicle(int orderId) {
		return repository.changeVehicle(orderId);
	}

	public Vehicle getVehicleById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Vehicle getVehicleByUserEmail(String userEmail) {
		Integer userId=userRepository.findUserIdByEmail(userEmail);
		if(userId==null) return null;
		else
		return repository.findByUserId(userId);
	}
	public Vehicle getVehicleByUserId(int userId) {
		return repository.findByUserId(userId);
	}
	public Vehicle getVehicleByOrderId(int userId, int orderId) {
		return repository.findByOrderId(userId,orderId);
	}

	public List<Vehicle> getVehicles() {
		return repository.findAll();
	}

	public List<Vehicle> getAllAvailableVehicles() {
		return repository.findAllAvailableVehicles();
	}
	public String deleteVehicle(int id) {
		repository.deleteById(id);
		return id + "deleted";
	}

	public Vehicle modifyVehicle(Vehicle vehicle) {
		Vehicle existingVehicle = repository.findById(vehicle.getId()).orElse(null);

		existingVehicle.setModel(vehicle.getModel());
		existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
		existingVehicle.setVehicleType(vehicle.getVehicleType());
		existingVehicle.setVehicleAvailability(vehicle.isVehicleAvailability());
		existingVehicle.setRevenueGenerated(vehicle.getRevenueGenerated());
		existingVehicle.setImgURL(vehicle.getImgURL());
		
		existingVehicle.setUserId(vehicle.getUserId());
		existingVehicle.setOrderId(vehicle.getOrderId());

		return repository.save(existingVehicle);

	}
	
	//get order list by userid of driver
	public List<Integer> getDriverAssignedOrderIds(int userId){
		return repository.getDriverAssignedOrderIds(userId);
	}
}
