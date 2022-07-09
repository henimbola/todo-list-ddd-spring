package com.whispro.TodoList.Todo.adapter.out.persistence;

import com.whispro.TodoList.Todo.adapter.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, UUID> {
}
