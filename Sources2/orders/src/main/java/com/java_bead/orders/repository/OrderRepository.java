package com.java_bead.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_bead.orders.model.Order;

// Rendelés repository-je
// A rendelés tárolásáért és lekérdezéséért felelős osztály
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
