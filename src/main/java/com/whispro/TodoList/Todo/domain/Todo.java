package com.whispro.TodoList.Todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(todoId, todo.todoId) && Objects.equals(title, todo.title) && status == todo.status;
    }

    @Override
    public int hashCode() {
        int todoIdLength = todoId.toString().length();
        int titleLength = title.length();
        int statusLength = status.toString().length();
        return todoIdLength + titleLength + statusLength;
    }
}
