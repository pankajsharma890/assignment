package com.uxpsystems.assignment.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uxpsystems.assignment.CustomException.StatusNotValidException;
import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.entity.UserEntity;
import com.uxpsystems.assignment.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping(path = "/users")
	public List<UserDto>  getAllUserDetails() {
		
		List<UserDto> userDtoList = userService.getAllUserDetails();
		
		return userDtoList;
		
	}
	
	@GetMapping(path = "/users/{id}")
	public UserDto  getUserDetailsById(@PathVariable Integer id) {
		
		UserDto userDto = userService.getUserDetailsId(id);
		
		return userDto;
		
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUserDetails(@Valid  @RequestBody UserDto userDto) throws StatusNotValidException {
		
		UserEntity user= userService.saveUser(userDto);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(user.getId()).toUri();
		return  ResponseEntity.created(location).build();
		 
		
	}
	
	@PutMapping(path = "/users")
	public void updateUserDetails(@RequestBody UserDto userDto) {
		userService.UpdateeUser(userDto);
		
	}
	
	@DeleteMapping(path = "/users")
	public void deleteUserDetails(@RequestBody UserDto userDto) {
		userService.DeleteUser(userDto);
	}

}
