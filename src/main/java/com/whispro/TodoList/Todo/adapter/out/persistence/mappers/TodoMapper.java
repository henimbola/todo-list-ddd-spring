package com.whispro.TodoList.Todo.adapter.out.persistence.mappers;

import com.whispro.TodoList.Todo.adapter.out.persistence.entities.TodoEntity;
import com.whispro.TodoList.Todo.domain.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    @Mapping(source = "state", target = "status")
    @Mapping(source = "id", target = "todoId")
    Todo map(TodoEntity todoEntity);
    @Mapping(source = "status", target = "state")
    @Mapping(source = "todoId", target = "id")
    TodoEntity map(Todo todo);

    List<Todo> map(List<TodoEntity> todos);
}
