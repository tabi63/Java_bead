package com.java_bead.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.java_bead.orders.model.Order;
import com.java_bead.orders.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id).orElse(new Order()));
        return "edit-order";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }
}
