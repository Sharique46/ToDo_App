// Import required libraries and classes
package com.todoproject.ToDo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.todoproject.ToDo.dto.TaskDto;
import com.todoproject.ToDo.entity.Task;
import com.todoproject.ToDo.exception.ResourceNotFoundException;
import com.todoproject.ToDo.mapper.TaskMapper;
import com.todoproject.ToDo.repository.TaskRepository;

import lombok.AllArgsConstructor;

// Define a service class for managing tasks
@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	private TaskRepository taskRepository;

	// Method to create a new task
	@Override
	public TaskDto createTask(TaskDto taskDto) {
		Task task = TaskMapper.maptoTask(taskDto);
		Task savedTask = taskRepository.save(task);
		return TaskMapper.maptoTaskDto(savedTask);
	}

	// Method to retrieve a task by its id
	@Override
	public TaskDto getTaskById(Long taskId) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exists with given id : " + taskId));
		return TaskMapper.maptoTaskDto(task);
	}

	// Method to retrieve all tasks
	@Override
	public List<TaskDto> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		return tasks.stream().map((task) -> TaskMapper.maptoTaskDto(task)).collect(Collectors.toList());
	}

	// Method to update a task
	@Override
	public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exists with a given id : " + taskId));

		task.setTitle(updatedTask.getTitle());
		task.setDescription(updatedTask.getDescription());
		task.setCompleted(updatedTask.getCompleted());
		taskRepository.save(task);
		return TaskMapper.maptoTaskDto(task);
	}

	// Method to delete a task
	@Override
	public void deleteTask(Long taskId) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Tasks not found  with a given id" + taskId));
		taskRepository.deleteById(taskId);
	}
}
