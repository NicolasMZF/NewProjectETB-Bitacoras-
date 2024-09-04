package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Here the query methods are added automatically so unless you want to add a custom one aight :)
    // Custom query methods can be defined here if needed
}