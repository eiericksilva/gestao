package com.eiericksilvagroup.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilvagroup.gestao.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
