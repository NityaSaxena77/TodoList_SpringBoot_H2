package com.springboot.todo;

import org.springframework.data.repository.CrudRepository;

import com.springboot.todo.entity.TodoListEntity;

public interface TodoListCrudRepository extends CrudRepository<TodoListEntity, Long>{

}
