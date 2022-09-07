package com.deliver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_data")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String model;
	@Column
	private String vehicleNumber;
	@Column
	private String vehicleType;
	@Column
	private int revenueGenerated;
	@Column
	private boolean vehicleAvailability;
    @Column
    private String imgURL;
    @Column
    private int orderId;
    @Column
    private int driverUserId;
    @Column
    private int userDlNumber;

  

	public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public int getDriverUserId() {
	return driverUserId;
}
public void setDriverUserId(int driverUserId) {
	this.driverUserId = driverUserId;
}
public int getUserDlNumber() {
	return userDlNumber;
}
public void setUserDlNumber(int userDlNumber) {
	this.userDlNumber = userDlNumber;
}
	public String getImgURL() {
    return imgURL;
  }
  public void setImgURL(String imgURL) {
    this.imgURL = imgURL;
  }
  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getRevenueGenerated() {
		return revenueGenerated;
	}
	public void setRevenueGenerated(int revenueGenerated) {
		this.revenueGenerated = revenueGenerated;
	}
	public boolean isVehicleAvailability() {
		return vehicleAvailability;
	}
	public void setVehicleAvailability(boolean vehicleAvailability) {
		this.vehicleAvailability = vehicleAvailability;
	}



	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(int id, String model, String vehicleNumber, String vehicleType, int revenueGenerated,
			boolean vehicleAvailability, String imgURL, int orderId, int driverUserId, int userDlNumber) {
		super();
		this.id = id;
		this.model = model;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.revenueGenerated = revenueGenerated;
		this.vehicleAvailability = vehicleAvailability;
		this.imgURL = imgURL;
		this.orderId = orderId;
		this.driverUserId = driverUserId;
		this.userDlNumber = userDlNumber;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", vehicleNumber=" + vehicleNumber + ", vehicleType="
				+ vehicleType + ", revenueGenerated=" + revenueGenerated + ", vehicleAvailability="
				+ vehicleAvailability + ", imgURL=" + imgURL + ", orderId=" + orderId + ", driverUserId=" + driverUserId
				+ ", userDlNumber=" + userDlNumber + "]";
	}
  


}
