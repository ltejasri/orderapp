package com.capgemini.orderapp.service;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.exception.OrderNotFoundException;

public interface OrderappService {

	public Order addOrder(Order order);
	public void deleteOrder(Order order);
	public Order updateOrder(Order order);
	public Order findOrderById(int OrderId) throws OrderNotFoundException;
	
}
