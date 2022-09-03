package com.deliver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complaintdb")
public class ComplaintStatus {

	@Column(name = "user_id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Id
	@Column(name = "complaint_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaint_id;
	@Column(name = "complaint_recieved")
	private String complaint;
	@Column(name = "enquiring")
	private String enquiring;
	@Column(name = "action_taken")
	private String action;
	@Column(name = "issue")
	private String issue;
	@Column(name = "order_id")
	private Integer order_id;

	public ComplaintStatus(Integer user_id, int complaint_id, String complaint, String enquiring, String action,
			String issue, Integer order_id) {
		super();
		this.user_id = user_id;
		this.complaint_id = complaint_id;
		this.complaint = complaint;
		this.enquiring = enquiring;
		this.action = action;
		this.issue = issue;
		this.order_id = order_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getEnquiring() {
		return enquiring;
	}

	public void setEnquiring(String enquiring) {
		this.enquiring = enquiring;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public ComplaintStatus() {
		super();
	}

	@Override
	public String toString() {
		return "user_id[user_id= " + user_id + " ,complaint_id= " + complaint_id + " ,complaint_received= " + complaint
				+ " ,enquiring= " + enquiring + ", action_taken= " + action + ", issue= " + issue + ", order_id= "
				+ order_id + "]";
	}

}
