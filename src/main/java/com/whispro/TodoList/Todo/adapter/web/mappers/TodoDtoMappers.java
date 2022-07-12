package com.whispro.TodoList.Todo.adapter.web.mappers;

import com.whispro.TodoList.Todo.adapter.web.dtos.TodoResponseDto;
import com.whispro.TodoList.Todo.domain.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoDtoMappers {

    Todo map(TodoResponseDto todo);
    TodoResponseDto map(Todo todo);
}
