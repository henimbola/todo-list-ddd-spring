package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.exceptions.TodoNotFoundException;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveTodoServiceTest {

    @Mock
    TodoRepositoryPort todoRepository;

    @InjectMocks
    RetrieveTodoService retrieveTodoService;

    @Test
    void shouldGetAllTodos() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();

        List<Todo> todos = List.of(todo);

        when(todoRepository.findAll()).thenReturn(todos);

        assertThat(retrieveTodoService.findAllTodos()).isEqualTo(todos);
    }

    @Test
    void shouldGetOneTodo() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();

        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));

        assertThat(retrieveTodoService.findTodo(id)).isEqualTo(todo);
    }

    @Test
    void shouldThrowNotFoundError() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).status(Status.CREATED).title("title").build();

        when(todoRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> retrieveTodoService.findTodo(id)).isInstanceOf(TodoNotFoundException.class).hasMessage("Todo not found");
    }
}
