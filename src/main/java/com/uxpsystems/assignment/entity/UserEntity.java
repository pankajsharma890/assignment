package com.uxpsystems.assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Entity
@Table(name ="USER")
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer Id ;
	
	@Size(min =2 ,message ="minimum length should 2")
	private String name;
	
	@NotEmpty(message = "Password can not empty")
	private String password;
	
	@NotEmpty(message = "status can not empty")
	private String status;
	
	public UserEntity() {
	}
	
	public UserEntity(Integer id, String name, String password, String status) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
		this.status = status;
	}



	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
