package com.qa.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.boot.model.Task;

public interface TaskRepository extends JpaRepository<Task , Integer> {
	//List<Task> findAll();

	
}
