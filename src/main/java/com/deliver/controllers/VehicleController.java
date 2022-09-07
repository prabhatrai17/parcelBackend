package com.deliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deliver.entities.Order;
import com.deliver.entities.Vehicle;
import com.deliver.Service.OrderService;
import com.deliver.Service.VehicleService;

@RestController
@CrossOrigin
public class VehicleController {

	@Autowired
	private VehicleService service;
	@Autowired
	private OrderService orderService;

	
	@PostMapping("/add_vehicle")
	public Vehicle addVehicle (@RequestBody Vehicle vehicle) {
		System.out.println(vehicle);
		return service.addVehicle(vehicle);
	}
//get by vehicle_id
	@GetMapping("/vehicle/{id}")
	public Vehicle findVehicleById(@PathVariable int id) {
		return service.getVehicleById(id);
	}
	//get vehicle by useremail
	@GetMapping("/vehicle/{userEmail}")
	public Vehicle findVehicleByuserEmail(@PathVariable String userEmail) {
		return service.getVehicleByUserEmail(userEmail);
	}
	//get vehicle by driverUserid
		@GetMapping("/vehicle-driver/{driverUserId}")
		public Vehicle getVehicleByUserId(@PathVariable int driverUserId) {
			return service.getVehicleByDriverUserId(driverUserId);
		}
	
	//method to get vehicle assigned for showing vehicle at customer side
	@GetMapping("/vehicle/{userId}/{orderId}")
	public Vehicle findVehicleByOrderId(@PathVariable int userId,@PathVariable int orderId) {
		return service.getVehicleByOrderId(userId,orderId);
	}

	//method to get all available vehicle
	@GetMapping("/vehicles")
	public List<Vehicle> findVehicles() {
		return service.getAllAvailableVehicles();
	}
	//get all vehicle
	@GetMapping("/vehicle")
	public List<Vehicle> Vehicles() {
		return service.getVehicles();
	}
	//get revenue of vehicle
		@GetMapping("/vehicle-revenue/{driverId}")
		public double getVehiclesRev(@PathVariable int driverId) {
			return service.getVehicleRev(driverId);
		}
	//get order list by driverUserId
	@RequestMapping(value = "/driver/orders/{driverUserId}", method = RequestMethod.GET)
	List<Integer> getAllOrders(@PathVariable int driverUserId) {	
	System.out.println("inside gelAllOrders"+driverUserId);
		
	return service.getDriverAssignedOrderIds(driverUserId);

	}
    //on selecting vehicle its updated with repective order_id
	@PutMapping("/update")
	public Vehicle modifyVehicle(@RequestBody Vehicle vehicle) {
		int driverUserId= vehicle.getDriverUserId();
		int orderId=vehicle.getOrderId();
		
		orderService.setDriverUserId(driverUserId,orderId);
		
		return service.modifyVehicle(vehicle);
	}

	@DeleteMapping
	public String deleteVehicle(@PathVariable int id) {
		return service.deleteVehicle(id);
	}



}
