package com.whispro.TodoList.Todo.adapter.out.persistence.mappers;

import com.whispro.TodoList.Todo.adapter.out.persistence.entities.TodoEntity;
import com.whispro.TodoList.Todo.domain.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo map(TodoEntity todoEntity);
    TodoEntity map(Todo todo);

    List<Todo> map(List<TodoEntity> todos);
}
