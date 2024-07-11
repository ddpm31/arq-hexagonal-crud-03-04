package com.example.hexagonal.domain.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime orderDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, String description, LocalDateTime orderDate) {
        this.id = id;
        this.description = description;
        this.orderDate = orderDate;
    }

    public void addItem(OrderItem item) {

        this.items.add(item);

    }

    public void removeItem(OrderItem item) {

        this.items.remove(item);

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public LocalDateTime getOrderDate() {

        return orderDate;

    }

    public void setOrderDate(LocalDateTime orderDate) {

        this.orderDate = orderDate;

    }

    public List<OrderItem> getItems() {

        return items;

    }

    public void setItems(List<OrderItem> items) {

        this.items = items;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
