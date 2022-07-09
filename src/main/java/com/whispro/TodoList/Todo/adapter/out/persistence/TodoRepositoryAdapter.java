package com.whispro.TodoList.Todo.adapter.out.persistence;

import com.whispro.TodoList.Todo.application.out.TodoRepositoryPort;
import com.whispro.TodoList.Todo.domain.Todo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TodoRepositoryAdapter implements TodoRepositoryPort {

    private final TodoJpaRepository todoJpaRepository;

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public Todo deleteById(UUID todoID) {
        return null;
    }

    @Override
    public Optional<Todo> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }
}
