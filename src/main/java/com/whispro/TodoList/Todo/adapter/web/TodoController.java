package com.whispro.TodoList.Todo.adapter.web;

import com.whispro.TodoList.Todo.application.in.CreateTodo;
import com.whispro.TodoList.Todo.application.in.CreateTodoCommand;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = {"/api/todos"})
public class TodoController {

    private final CreateTodo createTodoService;

    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
        Todo todo = createTodoService.apply(CreateTodoCommand.builder().title(createTodoRequest.getTitle()).build());
        return ResponseEntity.created(URI.create(String.format("/api/todos/%s", todo.getTodoId()))).build();
    }
}
