package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public UserRepository() {
        // Crear usuarios de ejemplo
        users.add(new User(nextId++, "Carlos Lopez", "carlos.Lopez@example.com"));
        users.add(new User(nextId++, "Juan Pae", "juan.Pae@example.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
            users.add(user);
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(user.getId())) {
                    users.set(i, user);
                    break;
                }
            }
        }
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}