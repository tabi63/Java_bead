package com.java_bead.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.java_bead.orders.model.Order;
import com.java_bead.orders.service.OrderService;
import com.java_bead.orders.service.OrderStateService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStateService orderStateService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping(params = "query")
    public String searchOrders(@RequestParam String query, Model model) {
        model.addAttribute("orders", orderService.search(query));
        model.addAttribute("query", query);
        return "orders";
    }
    
    @GetMapping("/create")
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        return "edit-order";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findById(id).orElse(new Order()));
        model.addAttribute("orderStates", orderStateService.findAll());
        return "edit-order";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }
}
