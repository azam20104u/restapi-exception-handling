package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class UserResource {
	
	@Id
	private Integer id;
	@NotNull(message="name can't be null or empty")
	@NotEmpty
	private String name;
}
