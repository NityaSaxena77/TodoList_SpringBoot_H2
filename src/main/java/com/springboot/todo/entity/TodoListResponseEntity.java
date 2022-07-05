package com.springboot.todo.entity;

public class TodoListResponseEntity {

	private String taskId;
	private String message;
	private String status;
	
	
	public TodoListResponseEntity(String taskId, String message, String status) {
		super();
		this.taskId = taskId;
		this.message = message;
		this.status = status;
	}
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TodoListResponseEntity [taskId=" + taskId + ", message=" + message + ", status=" + status + "]";
	}
	
}
