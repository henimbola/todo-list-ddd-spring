package com.whispro.TodoList.Todo.adapter.out.persistence;

import com.whispro.TodoList.Todo.adapter.out.persistence.entities.State;
import com.whispro.TodoList.Todo.adapter.out.persistence.entities.TodoEntity;
import com.whispro.TodoList.Todo.adapter.out.persistence.mappers.TodoMapper;
import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TodoRepositoryAdapter implements TodoRepositoryPort {

    private final TodoJpaRepository todoJpaRepository;
    private final TodoMapper todoMapper;

    @Override
    public Todo create(Todo todo) {
        TodoEntity savedTodoEntity = todoJpaRepository.save(todoMapper.map(todo));
        return todoMapper.map(savedTodoEntity);
    }

    @Override
    public void deleteById(UUID todoID) {
        todoJpaRepository.deleteById(todoID);
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return Optional.ofNullable(todoMapper.map(findTodoEntityById(id)));
    }

    @Override
    public List<Todo> findAll() {
        return todoMapper.map(todoJpaRepository.findAll());
    }

    @Override
    public void validateTodo(UUID todoID) {
        todoJpaRepository.save(findTodoEntityById(todoID).withState(State.FINISHED));
    }

    private TodoEntity findTodoEntityById(UUID id) {
        return todoJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }
}
