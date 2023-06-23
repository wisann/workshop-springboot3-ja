package com.wisan.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisan.project.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
