package com.whispro.TodoList.Todo.application.services;

import com.whispro.TodoList.Todo.application.exceptions.TodoNotFoundException;
import com.whispro.TodoList.Todo.application.in.EditTodo;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Status;
import com.whispro.TodoList.Todo.domain.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditTodoServiceTest {

    @Mock
    TodoRepositoryPort todoRepositoryPort;

    @InjectMocks
    EditTodoService editTodoService;

    @Test
    public void shouldReturnEditedTodo() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).title("old").status(Status.CREATED).build();
        Todo newTodo = todo.withTitle("new");
        EditTodo.EditTodoCommand editTodoCommand = EditTodo.EditTodoCommand.builder().id(id).title("new").build();

        when(todoRepositoryPort.findById(id)).thenReturn(Optional.of(todo));
        when(todoRepositoryPort.updateTodo(todo)).thenReturn(newTodo);

        assertThat(editTodoService.editTodo(editTodoCommand)).isEqualTo(newTodo);
    }

    @Test
    public void ShouldThrowTodoNotFoundException() {
        UUID id = UUID.fromString("cdab8181-beec-474b-9a30-f05d9c5f674e");

        Todo todo = Todo.builder().todoId(id).title("old").build();
        Todo newTodo = todo.withTitle("new");
        EditTodo.EditTodoCommand editTodoCommand = EditTodo.EditTodoCommand.builder().id(id).title("new").build();

        when(todoRepositoryPort.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> editTodoService.editTodo(editTodoCommand))
                .isInstanceOf(TodoNotFoundException.class)
                .hasMessage("Todo not found");
    }
}
