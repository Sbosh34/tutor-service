package com.sibonelo.tutorhub.tasks.api;

import java.time.Instant;
import java.util.List;

public record ApiError(Instant stamp, int status, String error, String path, List<FieldViolation> violations){
	public record FieldViolation(String field, String message){}
}
