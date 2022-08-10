package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidateTodoServiceTest {

    @Mock
    TodoRepositoryPort todoRepository;

    @InjectMocks
    ValidateTodoService validateTodoService;

    @Test
    void shouldValidateTodo() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");
        doNothing().when(todoRepository).validateTodo(id);

        validateTodoService.validate(id);

        verify(todoRepository).validateTodo(id);
    }
}
