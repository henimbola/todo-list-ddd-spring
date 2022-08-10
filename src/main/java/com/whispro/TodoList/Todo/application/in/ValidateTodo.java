package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.application.services.ValidateTodoService;
import com.whispro.TodoList.Todo.domain.Todo;

import java.util.UUID;

public interface ValidateTodo {
    void validate(UUID id);
}
