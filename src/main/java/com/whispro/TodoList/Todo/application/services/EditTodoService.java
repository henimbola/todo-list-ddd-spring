package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.exceptions.TodoNotFoundException;
import com.whispro.TodoList.Todo.application.in.EditTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EditTodoService implements EditTodo {

    final TodoRepositoryPort todoRepositoryPort;
    @Override
    public Todo editTodo(EditTodoCommand editTodoCommand) {
        Todo todo = todoRepositoryPort.findById(editTodoCommand.getId()).orElseThrow(TodoNotFoundException::new);
        return todoRepositoryPort.updateTodo(todo.withTitle(editTodoCommand.getTitle()));
    }
}
