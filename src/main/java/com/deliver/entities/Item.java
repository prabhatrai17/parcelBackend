package com.deliver.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Item {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	@Column
	private String itemName;
	@Column
	private int itemQty;
	@Column
	private String itemType;
	@Column
	private String itemDescription;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	
	@JsonBackReference
	private Order order;
	
	
	
	public Item(int itemId, String itemName, int itemQty, String itemType, String itemDescription, Order order) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQty = itemQty;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.order = order;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public String toString() {
//		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQty=" + itemQty + ", itemType=" + itemType
//				+ ", itemDescription=" + itemDescription + ", order=" + order + "]";
//	}
	
	
	
	
	

}
