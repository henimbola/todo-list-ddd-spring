package com.whispro.TodoList.Todo.adapter.web;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.PackagePrivate;

@Getter
@Builder
@PackagePrivate
public class CreateTodoRequest {
    private String title;
}
