package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.domain.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RetrieveTodo {

    List<Todo> findAllTodos();
    Todo findTodo(UUID id);
}
