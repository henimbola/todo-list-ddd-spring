package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.CreateTodo;
import com.whispro.TodoList.Todo.application.in.TodoCommand;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;

public class CreateTodoService implements CreateTodo {

    private final TodoRepositoryPort todoRepositoryPort;

    public CreateTodoService(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public Todo apply(TodoCommand todoCommand) {
        return null;
    }
}
