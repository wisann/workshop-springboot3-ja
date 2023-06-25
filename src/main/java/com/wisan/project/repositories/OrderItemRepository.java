package com.wisan.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisan.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
