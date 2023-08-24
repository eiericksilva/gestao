package com.eiericksilvagroup.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilvagroup.gestao.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
