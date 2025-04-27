package com.java_bead.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_bead.orders.model.OrderState;

// Rendelés állapot repository-je
// A rendelés állapot tárolásáért és lekérdezéséért felelős osztály
@Repository
public interface OrderStateRepository extends JpaRepository<OrderState, Integer> {
    OrderState findByDescription(String description);
}
