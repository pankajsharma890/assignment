package com.uxpsystems.assignment.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uxpsystems.assignment.CustomException.StatusNotValidException;
import com.uxpsystems.assignment.dao.UserRepository;
import com.uxpsystems.assignment.dto.UserDto;
import com.uxpsystems.assignment.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDto> getAllUserDetails() {
				
		List<UserEntity> userEntityList = new ArrayList<UserEntity>();
		userEntityList = userRepository.findAll();
		List<UserDto> userDtoList = mapUserEntityToUserDto(userEntityList);
		return userDtoList;
	
	}
	
	public UserDto getUserDetailsId(Integer id) {
		
		
		UserEntity userEntity = userRepository.getById(id);
		UserDto userDto = new UserDto();
		userDto.setId(userEntity.getId());
		userDto.setName(userEntity.getName());
		userDto.setPassword(userEntity.getPassword());
		userDto.setStatus(userEntity.getStatus());
		
		return userDto;
	
	}
	
	
	public UserEntity saveUser(UserDto userDto) throws StatusNotValidException {
		UserEntity userEntity= null;
		if(userDto.getStatus().equals("Active") || userDto.getStatus().equals("Deactive")) {
			userEntity = mapUserUserDtoToEntity(userDto);
			userRepository.save(userEntity);
		}else {
			throw new StatusNotValidException("Status can be Active or Deactive only");
		}
		

		return userEntity;
	}

	
	public UserEntity UpdateeUser(UserDto userDto) {
		
		UserEntity user = userRepository.getById(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setStatus(userDto.getStatus());
		userRepository.save(user);
		return user;
	}
	
	public UserEntity DeleteUser(UserDto userDto) {
		
		UserEntity userEntity = userRepository.getById(userDto.getId());
		userRepository.delete(userEntity);
		return userEntity;
	}
	
	private List<UserDto> mapUserEntityToUserDto(List<UserEntity> userEntityList) {
		
		List<UserDto> userDtoList =  new ArrayList<UserDto>();
		for(UserEntity u:userEntityList) {
			UserDto userDto = new UserDto();
			userDto.setId(u.getId());
			userDto.setName(u.getName());
			userDto.setPassword(u.getPassword());
			userDto.setStatus(u.getStatus());
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	private UserEntity mapUserUserDtoToEntity(UserDto userDto) {
		
		UserEntity ue =new UserEntity();
		ue.setName(userDto.getName());
		ue.setPassword(userDto.getPassword());
		ue.setStatus(userDto.getStatus());
		return ue;
	}



}
