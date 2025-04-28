package com.java_bead.orders.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_bead.orders.model.Order;
import com.java_bead.orders.model.OrderItem;
import com.java_bead.orders.repository.OrderItemRepository;

import jakarta.transaction.Transactional;

// Rendelés tételek szolgáltatása
@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    // Rendelés tételek frissítése rendelés alapján
    @Transactional
    public void updateOrderItems(Order order) {
        List<OrderItem> existingItems = orderItemRepository.findByOrderId(order.getId());

        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            for (OrderItem existingItem : existingItems) {
                existingItem.getOrder().getOrderItems().remove(existingItem);
                orderItemRepository.delete(existingItem);
            }

            return;
        }

        for (OrderItem existingItem : existingItems) {
            boolean stillExists = order.getOrderItems()
                .stream()
                .anyMatch(o -> o.getId() != null && o.getId().equals(existingItem.getId()));
            
            if (!stillExists) {
                existingItem.getOrder().getOrderItems().remove(existingItem);
                orderItemRepository.delete(existingItem);
            }
        }

        for (OrderItem incomingItem : order.getOrderItems()) {
            if (incomingItem.getProductName() == null || incomingItem.getPiece() == null || incomingItem.getUnitPrice() == null) {
                continue;
            } 

            if (incomingItem.getId() == null) {
                incomingItem.setOrder(order);
                incomingItem.setCreatedBy("system");
                incomingItem.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
                orderItemRepository.save(incomingItem);
            } else {
                OrderItem orderItem = orderItemRepository.findById(incomingItem.getId())
                    .orElseThrow(() -> new RuntimeException("OrderItem not found with id " + incomingItem.getId()));
        
                orderItem.setProductName(incomingItem.getProductName());
                orderItem.setPiece(incomingItem.getPiece());
                orderItem.setUnitPrice(incomingItem.getUnitPrice());
                orderItem.setLastModifiedBy("system");
                orderItem.setLastModifiedOn(new Timestamp(System.currentTimeMillis()));
            
                orderItemRepository.save(orderItem);
            }
        }
    }
}
