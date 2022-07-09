package com.whispro.TodoList.Todo.application.in;

import com.whispro.TodoList.Todo.domain.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateTodoCommand {
    private String title;
}
