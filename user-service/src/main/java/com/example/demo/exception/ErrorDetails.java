package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

	private LocalDateTime dateTime;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
