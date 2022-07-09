package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.ValidateTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ValidateTodoService implements ValidateTodo {

    private final TodoRepositoryPort todoRepositoryPort;

    @Override
    public void validate(ValidateTodoCommand validateTodoCommand) {
    }

    @Builder
    @Getter
    public class ValidateTodoCommand {
        UUID id;
        Todo todo;
    }
}
