package com.example.hexagonal.application.service;

import com.example.hexagonal.application.ports.OrderRepository;
import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.model.OrderItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }

    public Order createOrder(Order order) {

        return orderRepository.save(order);

    }

    public void addItemToOrder(Long orderId, OrderItem item) {

        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().addItem(item);
            orderRepository.save(order.get());
        }

    }

    public Optional<Order> getOrder(Long id) {

        return orderRepository.findById(id);

    }

    public List<Order> getAllOrders() {

        return orderRepository.findAll();

    }

    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);

    }
}