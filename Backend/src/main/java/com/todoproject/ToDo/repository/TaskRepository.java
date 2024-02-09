// Import necessary Spring libraries and Task entity
package com.todoproject.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoproject.ToDo.entity.Task;

// Define a repository interface for managing tasks
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
