package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.exceptions.TodoNotFoundException;
import com.whispro.TodoList.Todo.application.in.RetrieveTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RetrieveTodoService implements RetrieveTodo {

    final TodoRepositoryPort todoRepositoryPort;

    @Override
    public List<Todo> findAllTodos() {
        return todoRepositoryPort.findAll();
    }

    @Override
    public Todo findTodo(UUID id) {
        return todoRepositoryPort.findById(id).orElseThrow(TodoNotFoundException::new);
    }
}
