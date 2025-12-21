package com.sibonelo.tutorhub.tasks.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTaskRequest(
		//Title cannot be null/whitespace
		@NotBlank(message = "title is required")
		@Size(max = 120, message = "title must be 120 chars or less")
		String title
		){}
