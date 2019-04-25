package com.qa.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.boot.model.Users;
import com.qa.boot.repository.UserRepository;


@RestController
@RequestMapping("/demo/")
public class UserController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
    public List<Users> list(){
        return userRepository.findAll();
    }
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public Users get(@PathVariable Integer userId){
        return userRepository.findOne(userId);
    }

	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public Users delete(@PathVariable Integer userId){
        Users existingUser = userRepository.findOne(userId);
        userRepository.delete(existingUser);
        return existingUser;
    }

	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public Users update(@PathVariable Integer userId, @RequestBody Users user){
        Users existingUser = userRepository.findOne(userId);
        BeanUtils.copyProperties(user, existingUser);
        return userRepository.saveAndFlush(user);
    }
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
    public Users create(@RequestBody Users user){
        return userRepository.saveAndFlush(user);
    }
	




	
	
}
