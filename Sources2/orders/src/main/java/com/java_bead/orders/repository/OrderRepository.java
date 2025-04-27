package com.java_bead.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java_bead.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
