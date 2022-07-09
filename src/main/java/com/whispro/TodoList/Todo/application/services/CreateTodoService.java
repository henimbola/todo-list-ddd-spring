package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.CreateTodo;
import com.whispro.TodoList.Todo.application.in.CreateTodoCommand;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateTodoService implements CreateTodo {

    private final TodoRepositoryPort todoRepositoryPort;

    @Override
    public Todo apply(CreateTodoCommand createTodoCommand) {

        Todo todo = Todo.builder().title(createTodoCommand.getTitle()).status(Status.CREATED).build();

        return todoRepositoryPort.save(todo);
    }
}
