// Define a service interface for managing tasks
package com.todoproject.ToDo.service;

import java.util.List;

import com.todoproject.ToDo.dto.TaskDto;

// Interface TaskService outlines methods for task management
public interface TaskService {
	// Method to create a new task
	TaskDto createTask(TaskDto taskDto);

	// Method to retrieve a task by its id
	TaskDto getTaskById(Long taskId);

	// Method to retrieve all tasks
	List<TaskDto> getAllTasks();

	// Method to update a task
	TaskDto updateTask(Long taskId, TaskDto updatedTask);

	// Method to delete a task
	void deleteTask(Long taskId);
}
