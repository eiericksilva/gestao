package com.eiericksilvagroup.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilvagroup.gestao.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
