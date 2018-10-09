package com.capgemini.orderapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Order")
public class Order {
	
	@Id
	private int orderId;
	private int productId;
	private int customerId;
	
	public Order(int orderId, int productId, int customerId, LocalDate oderDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.customerId = customerId;
		
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


}