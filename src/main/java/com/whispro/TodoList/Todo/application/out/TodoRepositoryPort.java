package com.whispro.TodoList.Todo.application.out;

import com.whispro.TodoList.Todo.domain.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepositoryPort {
    Todo create(Todo todo);
    void deleteById(UUID todoID);
    Optional<Todo> findById(UUID id);
    List<Todo> findAll();

    void validateTodo(UUID todoID);
}
