package com.springboot.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ToDo_List_Details")
public class TodoListEntity {
	
	@GeneratedValue
	@Id
	private long taskId;
	
	@NotBlank(message="Task Name is mandatory")
	private String taskName;
	
	private String taskDesc;
	
	@Column(updatable = false)
	@CreationTimestamp
	private Date createDate;
	
	@UpdateTimestamp
	private Date updateDate;
	
	public TodoListEntity(){}

	
	
	public TodoListEntity(long taskId, String taskName, String taskDesc, Date createDate, Date updateDate) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	
	// Getters and setters of the related fields
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	

	@Override
	public String toString() {
		return "TodoListEntity [taskId=" + taskId + ", taskName=" + taskName + ", taskDesc=" + taskDesc
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	
	
	
	
		
}
