package com.java_bead.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_bead.orders.model.Order;
import com.java_bead.orders.model.OrderItem;
import com.java_bead.orders.model.OrderState;
import com.java_bead.orders.repository.OrderRepository;
import com.java_bead.orders.repository.OrderStateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStateRepository orderStateRepository;

    @Autowired
    private OrderItemService orderItemService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> search(String query) {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getCustomerName().toLowerCase().contains(query.toLowerCase())
                        || order.getCustomerAddress().toLowerCase().contains(query.toLowerCase())
                        || order.getAmount().toString().contains(query)
                        || order.getOrderState().getDescription().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public void save(Order order) {
        if (order.getId() == null) {
            addOrder(order);
        } else {
            updateOrderFields(order);
        }
    }

    private void addOrder(Order order) {
        order.setCreatedBy("system");
        order.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));

        OrderState orderedState = orderStateRepository.findByDescription("Ordered");
        order.setOrderState(orderedState);

        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(order);
            item.setCreatedBy("system");
            item.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
        }

        orderRepository.save(order);
    }

    private void updateOrderFields(Order order) {
        Order originalOrder = orderRepository.findById(order.getId())
            .orElseThrow(() -> new RuntimeException("Order not found with id " + order.getId()));


        originalOrder.setCustomerName(order.getCustomerName());
        originalOrder.setCustomerAddress(order.getCustomerAddress());
        originalOrder.setOrderDate(order.getOrderDate());
        originalOrder.setAmount(order.getAmount());
        originalOrder.setLastModifiedBy("system");
        originalOrder.setLastModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
        originalOrder.setOrderState(order.getOrderState());

        orderRepository.save(originalOrder);


        /* orderRepository.updateOrderFields(
                order.getId(),
                order.getCustomerName(),
                order.getCustomerAddress(),
                order.getOrderDate(),
                order.getAmount(),
                order.getLastModifiedBy(),
                order.getLastModifiedOn(),
                order.getOrderState()
        ); */

        orderItemService.updateOrderItems(order);
    }
}
