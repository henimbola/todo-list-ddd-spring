package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.in.CreateTodoCommand;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTodoServiceTest {

    @Mock
    TodoRepositoryPort todoRepositoryPort;

    @InjectMocks
    CreateTodoService createTodoService;

    @Test
    void shouldCreateTest() {

        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todoCreated = Todo.builder().title("todo1").status(Status.CREATED).todoId(id).build();
        CreateTodoCommand createTodoCommand = CreateTodoCommand.builder().title("todo1").build();

        when(todoRepositoryPort.create(any())).thenReturn(todoCreated);
        assertThat(createTodoService.apply(createTodoCommand)).isEqualTo(todoCreated);
    }
}
