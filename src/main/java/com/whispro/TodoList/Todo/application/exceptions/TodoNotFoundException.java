package com.whispro.TodoList.Todo.application.exceptions;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException() {
        super("Todo not found");
    }
}
