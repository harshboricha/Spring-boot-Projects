package com.example.todo_app.model;

import jakarta.persistence.*;
import lombok.Setter;

/**
 * @Entity tells Spring Data JPA that this class maps to a database table.
 * Every instance of Todo will be stored as a row in the "todo" table.
 *
 * @Id marks the primary key of this entity.
 * @GeneratedValue(strategy = GenerationType.IDENTITY) tells the DB to auto-generate the ID.
 */
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented primary key
    private Long id;

    /**
     * The title of the task.
     * By default, fields become columns in the table.
     */
    @Setter
    private String title;

    /**
     * Boolean field to track if the task is completed.
     * Default = false (incomplete).
     */
    @Setter
    private boolean completed = false;

    // Default constructor is required by JPA.
    public Todo() {}

    // Constructor to quickly create a Todo with just a title.
    public Todo(String title) {
        this.title = title;
    }

    // Getters and Setters (so JPA + JSON can access fields)
    public Long getId() { return id; }

    public String getTitle() { return title; }

    public boolean isCompleted() { return completed; }
}
