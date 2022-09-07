package com.deliver.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FullOrderObj {
	
	
	//private int orderId;
	private String orderDate;
	private String orderCompleted;
	private Item item;
	private User user;
	
	private String pickupAddress;
    private String dropAddress;
    private int estDistance;
    private double estCost;
    private String paymentStatus;
	
	private String pickupStatus;
	
	private String dispatchStatus;
	
	private String arrivingStatus;
	
	private String deliveryStatus;
	
	
	
	
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
	public int getEstDistance() {
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public FullOrderObj(String orderDate, String orderCompleted, Item item, User user, String pickupAddress,
			String dropAddress, int estDistance, double estCost, String pickupStatus, String dispatchStatus,
			String arrivingStatus, String deliveryStatus) {
		super();
		this.orderDate = orderDate;
		this.orderCompleted = orderCompleted;
		this.item = item;
		this.user = user;
		this.pickupAddress = pickupAddress;
		this.dropAddress = dropAddress;
		this.estDistance = estDistance;
		this.estCost = estCost;
		this.pickupStatus = pickupStatus;
		this.dispatchStatus = dispatchStatus;
		this.arrivingStatus = arrivingStatus;
		this.deliveryStatus = deliveryStatus;
	}
	public FullOrderObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FullOrderObj [orderDate=" + orderDate + ", orderCompleted=" + orderCompleted + ", item=" + item
				+ ", user=" + user + ", pickupAddress=" + pickupAddress + ", dropAddress=" + dropAddress
				+ ", estDistance=" + estDistance + ", estCost=" + estCost + ", paymentStatus=" + paymentStatus
				+ ", pickupStatus=" + pickupStatus + ", dispatchStatus=" + dispatchStatus + ", arrivingStatus="
				+ arrivingStatus + ", deliveryStatus=" + deliveryStatus + "]";
	}

	
	
	
	

}
