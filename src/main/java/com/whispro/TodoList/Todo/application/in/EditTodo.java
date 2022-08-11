package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

public interface EditTodo {

    public Todo editTodo(EditTodoCommand editTodoCommand);

    @Builder
    @Getter
    class EditTodoCommand {
        UUID id;
        String title;
    }
}
