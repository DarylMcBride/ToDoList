package com.qa.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.boot.model.Task;
import com.qa.boot.repository.TaskRepository;

@RestController
@RequestMapping("/demo/")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping(value = "task", method = RequestMethod.GET)
    public List<Task> list(){
        return taskRepository.findAll();
        
    }
	
	@RequestMapping(value = "task/{id}", method = RequestMethod.GET)
    public Task get(@PathVariable Integer id){
        return taskRepository.findOne(id);
    }
	

	@RequestMapping(value = "task/{id}", method = RequestMethod.DELETE)
    public Task delete(@PathVariable Integer id){
        Task existingTask = taskRepository.findOne(id);
        taskRepository.delete(existingTask);
        return existingTask;
    }

	@RequestMapping(value = "task/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable Integer id, @RequestBody Task task){
        Task existingTask = taskRepository.findOne(id);
        BeanUtils.copyProperties(task, existingTask);
        return taskRepository.saveAndFlush(task);
    }
	
	@RequestMapping(value = "task", method = RequestMethod.POST)
    public Task create(@RequestBody Task task){
        return taskRepository.saveAndFlush(task);
    }
	
	
	

}
