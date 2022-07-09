package com.whispro.TodoList.Todo.adapter.web;

import com.whispro.TodoList.Todo.application.in.CreateTodo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = {"/api/todos"})
public class TodoController {

    private final CreateTodo createTodoService;

    @PostMapping
    public void createTodo(@RequestBody CreateTodoRequest createTodoRequest) {}
}
