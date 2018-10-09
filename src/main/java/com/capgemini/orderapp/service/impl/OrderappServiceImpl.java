package com.capgemini.orderapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.exception.OrderNotFoundException;
import com.capgemini.orderapp.repository.OrderappRepository;
import com.capgemini.orderapp.service.OrderappService;

@Service
public class OrderappServiceImpl implements OrderappService{

	@Autowired
	private OrderappRepository orderappRepository;
	@Override
	public Order addOrder(Order order) {
		return orderappRepository.save(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderappRepository.delete(order);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderappRepository.save(order);
	}

	@Override
	public Order findOrderById(int OrderId) throws OrderNotFoundException {
		Optional<Order> optionalOrder = orderappRepository.findById(OrderId);
		if(optionalOrder.isPresent())
			return optionalOrder.get();
		throw new OrderNotFoundException("Order does not exists");
	}
	
	

}
