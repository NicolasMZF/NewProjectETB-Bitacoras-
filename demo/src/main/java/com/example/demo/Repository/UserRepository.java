package com.example.demo.repository;

import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Here the query methods are added automatically so unless you want to add a custom one aight :)
    // Custom query methods can be defined here if needed
}