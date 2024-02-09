// Define a mapper class for mapping between Task and TaskDto objects
package com.todoproject.ToDo.mapper;

import com.todoproject.ToDo.dto.TaskDto;
import com.todoproject.ToDo.entity.Task;

public class TaskMapper {

	// Method to map TaskDto to Task entity
	public static TaskDto maptoTaskDto(Task task) {
		return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
	}

	// Method to map Task to TaskDto object
	public static Task maptoTask(TaskDto taskDto) {
		return new Task(taskDto.getId(), taskDto.getTitle(), taskDto.getDescription(), taskDto.getCompleted());
	}

}
