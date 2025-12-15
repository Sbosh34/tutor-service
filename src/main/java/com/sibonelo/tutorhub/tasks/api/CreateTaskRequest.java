package com.sibonelo.tutorhub.tasks.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest(
	@NotBlank(message = "title is required")
	@Size(max = 120, message = "title must be at most 120 characters")
	String title	
){}
