package com.java_bead.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_bead.orders.model.OrderState;
import com.java_bead.orders.repository.OrderStateRepository;

// Rendelés állapot szolgáltatás
@Service
public class OrderStateService {
    
    @Autowired
    private OrderStateRepository orderStateRepository;

    // Rendelés állapotok lekérdezése
    public List<OrderState> findAll() {
        return orderStateRepository.findAll();
    }
}
