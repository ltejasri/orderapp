package com.capgemini.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.orderapp.entity.Order;

public interface OrderappRepository extends JpaRepository<Order, Integer>{

}
