package com.example.todo_app.repository;

import com.example.todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository is where we define how we interact with the database.
 *
 * By extending JpaRepository<Todo, Long>, we get all CRUD methods for free:
 *   - findAll()
 *   - findById(id)
 *   - save(entity)
 *   - deleteById(id)
 *
 * We don’t write SQL here. JPA + Hibernate generates it automatically.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // No code needed here unless we want custom queries later
}
