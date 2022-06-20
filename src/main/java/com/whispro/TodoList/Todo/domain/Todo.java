package com.whispro.TodoList.Todo.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Todo {

    UUID todoId;
    String title;
    Status status;

    public Todo(UUID id, String title) {
        this.todoId = id;
        this.title = title;
        this.status = Status.CREATED;
    }

    public void finishStatus() {
        this.status = Status.FINISHED;
    }
}
