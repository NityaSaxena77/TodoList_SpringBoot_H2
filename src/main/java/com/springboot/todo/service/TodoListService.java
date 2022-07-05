package com.springboot.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.todo.TodoListCrudRepository;
import com.springboot.todo.entity.TodoListEntity;

@Service
public class TodoListService {
	
	@Autowired
	TodoListCrudRepository todoListCrudRepository;
	
	public List<TodoListEntity> viewTodoList(){
		
		List<TodoListEntity> allTodoList = new ArrayList<>();
		todoListCrudRepository.findAll().forEach(task -> allTodoList.add(task));
		return allTodoList;		
	
	}
	
	public void addTaskToTodoList(TodoListEntity task) {
		
		todoListCrudRepository.save(task);
		
	}
	
	public void updateTodoList(long taskId, TodoListEntity task) {
		
		TodoListEntity taskDetails = todoListCrudRepository.findById(taskId).get();
		
		taskDetails.setTaskName(task.getTaskName());
		taskDetails.setTaskDesc(task.getTaskDesc());
		todoListCrudRepository.save(taskDetails);
		
	}
	
	public void deleteTaskFromTodoList(long taskId) {
		
		todoListCrudRepository.deleteById(taskId);
	}
	
	public boolean taskPresent(long taskId) {
		boolean taskPresent = todoListCrudRepository.findById(taskId).isPresent();
		return taskPresent;
	}
}
