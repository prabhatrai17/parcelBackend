//package com.deliver.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "orderd")
//public class Status {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	@Column(name = "user_id")
//	private Integer userId;
//	@Column(name = "order_id")
//	private Integer orderId;
//	@Column(name = "pickup_status")
//	private String pickupStatus;
//	@Column(name = "dispatch_status")
//	private String dispatchStatus;
//	@Column(name = "arriving_status")
//	private String arrivingStatus;
//	@Column(name = "delivery_status")
//	private String deliveryStatus;
//	
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Integer orderId) {
//		this.orderId= orderId;
//	}
//
//	public String getPickupStatus() {
//		return pickupStatus;
//	}
//
//	public void setPickupStatus(String pickupStatus) {
//		this.pickupStatus = pickupStatus;
//	}
//
//	public String getDispatchStatus() {
//		return dispatchStatus;
//	}
//
//	public void setDispatchStatus(String dispatchStatus) {
//		this.dispatchStatus = dispatchStatus;
//	}
//
//	public String getArrivingStatus() {
//		return arrivingStatus;
//	}
//
//	public void setArrivingStatus(String arrivingStatus) {
//		this.arrivingStatus = arrivingStatus;
//	}
//
//	public String getDeliveryStatus() {
//		return deliveryStatus;
//	}
//
//	public void setDeliveryStatus(String deliveryStatus) {
//		this.deliveryStatus = deliveryStatus;
//	}
//
//    public Status(Integer userId,Integer orderId,String pickupStatus,String dispatchStatus,String arrivingStatus,String deliveryStatus)
//    {
//        super();
//        this.userId = userId;
//        this.orderId = orderId;
//        this.pickupStatus = pickupStatus;
//        this.dispatchStatus = dispatchStatus;
//        this.arrivingStatus = arrivingStatus;
//        this.deliveryStatus = deliveryStatus;
//    }
//
//    public Status()
//    {
//        super();
//    }
//
//    @Override
//    public String toString()
//    {
//        return "userId[userId=" + userId + ", orderId=" + orderId 
//        + ", pickupStatus=" + pickupStatus + ",dispatchStatus=" 
//        + dispatchStatus + ",arrivingStatus=" + arrivingStatus 
//        + "deliveryStatus=" + deliveryStatus + "]";  
//    }
//	
//
//	
//
//}
