package com.whispro.TodoList.Todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

import java.util.UUID;

@Getter
@Builder
public class Todo {

    UUID todoId;

    @With
    String title;
    @With
    Status status;

    public void finishStatus() {
        this.status = Status.FINISHED;
    }
}
