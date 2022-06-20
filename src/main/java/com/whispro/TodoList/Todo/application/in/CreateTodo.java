package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.domain.Todo;

import java.util.function.Function;

public interface CreateTodo extends Function<TodoCommand, Todo> {
}
