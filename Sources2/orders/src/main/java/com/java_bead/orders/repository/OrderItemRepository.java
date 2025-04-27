package com.java_bead.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_bead.orders.model.OrderItem;

// Rendelés tételek repository-je
// A rendelés tételek tárolásáért és lekérdezéséért felelős osztály
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
