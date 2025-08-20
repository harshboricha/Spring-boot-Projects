package com.example.todo_app.service;

import com.example.todo_app.model.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service marks this class as a service bean (business logic layer).
 *
 * Why use a service layer?
 *   - Keeps controller thin (only handles HTTP requests).
 *   - Keeps database logic (repository) separate from API logic.
 *   - Good for maintainability and testing.
 */
@Service
public class TodoService {

    private final TodoRepository repository;

    // Constructor Injection: Spring automatically injects TodoRepository
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // Get all todos from DB
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    // Create a new todo
    public Todo createTodo(Todo todo) {
        return repository.save(todo); // save() inserts into DB
    }

    // Update an existing todo
    public Todo updateTodo(Long id, Todo updatedTodo) {
        return repository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return repository.save(todo); // save() updates if ID exists
        }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    // Delete todo by ID
    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
