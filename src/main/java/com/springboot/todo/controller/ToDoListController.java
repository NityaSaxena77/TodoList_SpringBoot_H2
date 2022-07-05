package com.springboot.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todo.entity.TodoListEntity;
import com.springboot.todo.entity.TodoListResponseEntity;
import com.springboot.todo.service.TodoListService;


@RestController
public class ToDoListController {

	@Autowired
	TodoListService todoListService;
	
	/**
	 * View all the tasks in the todo list
	 * 
	 * @return
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/todolist/view")
    public List<TodoListEntity> viewTasksTodoList(){
        return todoListService.viewTodoList();

    }
	
	/**
	 * Add the specified task in the todo list
	 * 
	 * @param taskToAdd
	 * @return
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/todolist/add")
    public TodoListResponseEntity addTasksTodoList(@Valid @RequestBody TodoListEntity taskToAdd){
		
        todoListService.addTaskToTodoList(taskToAdd);
        long taskIdAdded = taskToAdd.getTaskId();
        
        if(taskIdAdded > 0) {
        	TodoListResponseEntity todoResponse = new TodoListResponseEntity(Long.toString(taskIdAdded), "Task Added Successfully"
        			, "Ok");
        	return todoResponse;
        }else {
        	TodoListResponseEntity todoResponse = new TodoListResponseEntity("", "Task Not Added"
        			, "Bad Request");
        	return todoResponse;
        }
       
    }
	
	
	/**
	 * Update the specified task in the todo list
	 * 
	 * @param taskId, taskToUpdate
	 * @return
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/todolist/update/{taskId}")
    public TodoListResponseEntity updateTasksTodoList(@PathVariable long taskId, @RequestBody TodoListEntity taskToUpdate){
		
		// Check if the taskId provided exists in the system
		boolean taskExists = todoListService.taskPresent(taskId);
		
		if(taskExists) {
			todoListService.updateTodoList(taskId,taskToUpdate);	
			TodoListResponseEntity todoResponse = new TodoListResponseEntity(Long.toString(taskId), "Task Updated Successfully"
        			, "Ok");
        	return todoResponse;
		}else {
			TodoListResponseEntity todoResponse = new TodoListResponseEntity(Long.toString(taskId), "Task Does not Exist"
        			, "Not Found");
        	return todoResponse;
		}

    }


	/**
	 * Delete the specified task in the todo list
	 * 
	 * @param taskId
	 * @return
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/todolist/delete/{taskId}")
    public TodoListResponseEntity deleteTasksTodoList(@PathVariable long taskId){
		
		// Check if the taskId provided exists in the system
		boolean taskExists = todoListService.taskPresent(taskId);
		
		if(taskExists) {
			todoListService.deleteTaskFromTodoList(taskId);
			TodoListResponseEntity todoResponse = new TodoListResponseEntity(Long.toString(taskId), "Task Deleted Successfully"
        			, "Ok");
        	return todoResponse;
		}else {
			TodoListResponseEntity todoResponse = new TodoListResponseEntity(Long.toString(taskId), "Task Does not Exist"
        			, "Not Found");
        	return todoResponse;
		} 
		

    }
	
}
