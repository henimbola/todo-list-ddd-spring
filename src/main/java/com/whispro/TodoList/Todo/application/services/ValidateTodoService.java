package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.ValidateTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ValidateTodoService implements ValidateTodo {
    private final TodoRepositoryPort todoRepositoryPort;

    @Override
    public void validate(UUID id) {
        todoRepositoryPort.validateTodo(id);
    }
}
