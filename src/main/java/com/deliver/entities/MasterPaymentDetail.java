package com.deliver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MasterPaymentDetail {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String holderName;
	@Column
	private String cardNo;
	@Column
	private String cardType;
	@Column
	private String cardExpiryDate;
	@Column
	private int cvvNo;
	@Column
	private int cardPin;
	@Column
	private int availableBalance;
	
	
	
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public int getCvvNo() {
		return cvvNo;
	}
	public void setCvvNo(int cvvNo) {
		this.cvvNo = cvvNo;
	}
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}
	public int getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public MasterPaymentDetail(int id, String holderName, String cardNo, String cardType, String cardExpiryDate,
			int cvvNo, int cardPin, int availableBalance) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.cardExpiryDate = cardExpiryDate;
		this.cvvNo = cvvNo;
		this.cardPin = cardPin;
		this.availableBalance = availableBalance;
	}
	public MasterPaymentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MasterPaymentDetail [id=" + id + ", holderName=" + holderName + ", cardNo=" + cardNo + ", cardType="
				+ cardType + ", cardExpiryDate=" + cardExpiryDate + ", cvvNo=" + cvvNo + ", cardPin=" + cardPin
				+ ", availableBalance=" + availableBalance + "]";
	}
	
	
	
	
	
	

}
