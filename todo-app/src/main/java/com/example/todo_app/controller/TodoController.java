package com.example.todo_app.controller;

import com.example.todo_app.model.Todo;
import com.example.todo_app.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @RestController = @Controller + @ResponseBody
 *   - It tells Spring this is a REST API (JSON in / JSON out).
 *
 * @RequestMapping("/api/todos") → all endpoints start with "/api/todos".
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    // Constructor Injection: Spring provides TodoService here
    public TodoController(TodoService service) {
        this.service = service;
    }

    /**
     * GET /api/todos
     * Returns all todos as JSON.
     */
    @GetMapping
    public List<Todo> getTodos() {
        return service.getAllTodos();
    }

    /**
     * POST /api/todos
     * Creates a new todo.
     * @RequestBody → converts JSON from request into a Todo object.
     */
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

//
//    @PostMapping
//    public Todo createTodso(@RequestBody Todo todo){
//        return service.createTodo(todo);
//    }
    /**
     * PUT /api/todos/{id}
     * Updates an existing todo with given id.
     */
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    /**
     * DELETE /api/todos/{id}
     * Deletes a todo by id.
     */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
    }
}
