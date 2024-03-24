package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserResource {
	
	@Id
	private Integer id;
	private String name;
}
