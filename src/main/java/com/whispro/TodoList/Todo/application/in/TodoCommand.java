package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.domain.Status;

import java.util.UUID;

public class TodoCommand {

    private final String title;
    private final Status status;

    public TodoCommand(String title, Status status) {
        this.title = title;
        this.status = status;
    }
}
