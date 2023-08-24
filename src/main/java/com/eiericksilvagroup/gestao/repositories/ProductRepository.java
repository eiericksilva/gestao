package com.eiericksilvagroup.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilvagroup.gestao.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
