package com.deliver.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column
	private String orderDate;
	@Column
	private String orderCompleted;
//	@Column
//	private int userId;
	
//    public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	@OneToOne(cascade=CascadeType.MERGE)
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
//	@JoinColumn(name="item_id" ,referencedColumnName="item_id")
    @JsonManagedReference
	private List<Item> item;
	@Column
	private String pickupAddress;
	@Column
    private String dropAddress;
	@Column
    private int estDistance;
	@Column
    private double estCost;
	@Column
	private String pickupStatus;
	@Column
	private String dispatchStatus;
	@Column
	private String arrivingStatus;
	@Column
	private String deliveryStatus;
	@Column
	private String driverUserId;
	@Column
	private String paymentStatus;
	
	
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public String getDropAddress() {
		return dropAddress;
	}
	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}
	public float getEstDistance() {
		return estDistance;
	}
	public void setEstDistance(int estDistance) {
		this.estDistance = estDistance;
	}
	public double getEstCost() {
		return estCost;
	}
	public void setEstCost(double estCost) {
		this.estCost = estCost;
	}
	public String getDriverUserId() {
		return driverUserId;
	}
	public void setDriverUserId(String driverUserId) {
		this.driverUserId = driverUserId;
	}
	public String getPickupStatus() {
		return pickupStatus;
	}
	public void setPickupStatus(String pickupStatus) {
		this.pickupStatus = pickupStatus;
	}
	public String getDispatchStatus() {
		return dispatchStatus;
	}
	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}
	public String getArrivingStatus() {
		return arrivingStatus;
	}
	public void setArrivingStatus(String arrivingStatus) {
		this.arrivingStatus = arrivingStatus;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
    public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	////	
//	
//	
//	public Item getItem() {
//		return this.item;
//	}
//	public void setItem(Item item) {
//		this.item = item;
//	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//	private String orderStatus;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderCompleted() {
		return orderCompleted;
	}
	public void setOrderCompleted(String orderCompleted) {
		this.orderCompleted = orderCompleted;
	}
	
	
	

	
	public Order() {
		super();
		
	}
	public Order(int orderId, String orderDate, String orderCompleted, User user, List<Item> item, String pickupAddress,
			String dropAddress, int estDistance, double estCost, String pickupStatus, String dispatchStatus,
			String arrivingStatus, String deliveryStatus, String driverUserId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderCompleted = orderCompleted;
		this.user = user;
		this.item = item;
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.estDistance = estDistance;
		this.estCost = estCost;
		this.pickupStatus = pickupStatus;
		this.dispatchStatus = dispatchStatus;
		this.arrivingStatus = arrivingStatus;
		this.deliveryStatus = deliveryStatus;
		this.driverUserId = driverUserId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderCompleted=" + orderCompleted
				+ ", user=" + user + ", item=" + item + ", pickupAddress=" + pickupAddress + ", dropAddress="
				+ dropAddress + ", estDistance=" + estDistance + ", estCost=" + estCost + ", pickupStatus="
				+ pickupStatus + ", dispatchStatus=" + dispatchStatus + ", arrivingStatus=" + arrivingStatus
				+ ", deliveryStatus=" + deliveryStatus + ", driverUserId=" + driverUserId + ", paymentStatus="
				+ paymentStatus + "]";
	}

	

	




	
	
   
}
