package com.deliver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbackdb")
public class Feedback {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private Integer user_id;
	@Column(name = "order_id")
	private Integer order_id;
	@Column(name = "feedback")
	private String feedback;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	public Feedback(int id, Integer user_id, Integer order_id, String feedback) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.feedback = feedback;
	}
	public Feedback()
	{
		super();
	}
	
	public String toString()
	{
		return "order_id= "+order_id+" feedback= "+feedback;
	}
	
	
}
