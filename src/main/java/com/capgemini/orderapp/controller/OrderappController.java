package com.capgemini.orderapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.orderapp.entity.Order;
import com.capgemini.orderapp.exception.OrderNotFoundException;
import com.capgemini.orderapp.service.OrderappService;

@RestController
public class OrderappController {

	@Autowired
	private OrderappService orderappService;

	@PostMapping("/order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		ResponseEntity<Order> responseEntity = 
				new ResponseEntity<Order>(orderappService.addOrder(order), HttpStatus.OK);
		
		return responseEntity;
		
		@DeleteMapping("/order")
		public ResponseEntity<Order> deleteOrder(@RequestBody Order order) {
			try {
				Order orderFromDb = 
						orderappService.findOrderById(order.getOrderId());
				if(orderFromDb != null){
					orderappService.deleteOrder(orderFromDb);
					return new ResponseEntity<Order>(HttpStatus.OK);
				}
			}
			catch(OrderNotFoundException exception) {
				//logged the exception
			}		
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
		
		@PutMapping("/order/{orderId}")
		public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
			try {
				Order orderFromDb = 
						orderappService.findOrderById(order.getOrderId());
			
					return new ResponseEntity<Order>(orderappService.updateOrder(order), HttpStatus.OK);
			}
			catch(OrderNotFoundException exception) {
				//logged the exception
			}		
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
			}
		
	}

}
