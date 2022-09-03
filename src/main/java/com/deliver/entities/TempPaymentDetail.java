package com.deliver.entities;


//temp class to store card detail from frontend. ITS NOT ENTITY
public class TempPaymentDetail {
	
	private String cardNo;
	private String expiry;
	private int cvv;
	private int pin;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public TempPaymentDetail(String cardNo, String expiry, int cvv, int pin) {
		super();
		this.cardNo = cardNo;
		this.expiry = expiry;
		this.cvv = cvv;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "TempPaymentDetail [cardNo=" + cardNo + ", expiry=" + expiry + ", cvv=" + cvv + ", pin=" + pin + "]";
	}
	
	

}
