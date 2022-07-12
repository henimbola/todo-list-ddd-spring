package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.ValidateTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;
import java.util.UUID;

@RequiredArgsConstructor
public class ValidateTodoService implements ValidateTodo {

    private final TodoRepositoryPort todoRepositoryPort;

    @Override
    public void validate(ValidateTodoCommand validateTodoCommand) {
        Todo todoToValidate = todoRepositoryPort.findById(
                validateTodoCommand.getId()).orElseThrow(
                        () -> new IllegalArgumentException(MessageFormat.format(
                                "The todo with the id {0} was not found", validateTodoCommand
                        )));

        todoRepositoryPort.validateTodo(validateTodoCommand.getId(), todoToValidate.withStatus(Status.FINISHED));
    }

    @Builder
    @Getter
    public static class ValidateTodoCommand {
        UUID id;
        Todo todo;
    }
}
