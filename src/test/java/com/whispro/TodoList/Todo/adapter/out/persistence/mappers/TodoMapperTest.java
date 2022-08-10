package com.whispro.TodoList.Todo.adapter.out.persistence.mappers;

import com.whispro.TodoList.Todo.adapter.out.persistence.entities.State;
import com.whispro.TodoList.Todo.adapter.out.persistence.entities.TodoEntity;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TodoMapperTest {

    private final TodoMapper todoMapper = Mappers.getMapper(TodoMapper.class);

    @Test
    void shouldMapEntityToTodo() {

        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();
        TodoEntity todoEntity = TodoEntity.builder().id(id).state(State.CREATED).title("title").build();

        assertThat(todoMapper.map(todoEntity)).isEqualTo(todo);
    }

    @Test
    void shouldMapTodoToEntity() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();
        TodoEntity todoEntity = TodoEntity.builder().id(id).state(State.CREATED).title("title").build();

        assertThat(todoMapper.map(todo)).isEqualTo(todoEntity);
    }

    @Test
    void shouldMapEntityListToTodo() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();
        TodoEntity todoEntity = TodoEntity.builder().id(id).state(State.CREATED).title("title").build();

        assertThat(List.of(todo)).isEqualTo(todoMapper.map(List.of(todoEntity)));
    }
}
