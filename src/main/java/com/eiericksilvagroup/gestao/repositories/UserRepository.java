package com.eiericksilvagroup.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eiericksilvagroup.gestao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
