package com.sibonelo.tutorhub.tasks.api;

import com.sibonelo.tutorhub.tasks.domain.Task;
import com.sibonelo.tutorhub.tasks.repo.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController{
	
	private final TaskRepository repo;

	public TaskController(TaskRepository repo){
		this.repo = repo;
	}

	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)

	public TaskResponse create(@Valid @RequestBody CreateTaskRequest request){
		Task task = new Task(request.title());
		Task saved = repo.save(task);

		return toResponse(saved);
	}

	@GetMapping
	public List<TaskResponse> list(){
		return repo.findAll().stream().map(this::toResponse).toList();
	}
	
	@GetMapping("/{id}")
	public TaskResponse getById(@PathVariable Long id){
		Task task = repo.findById(id).orElseThrow( () -> new NotFoundException("Task with id "+ id + " not found"));
		return toResponse(task);
	}
	private TaskResponse toResponse(Task task){
		return new TaskResponse(task.getId(), task.getTitle(), task.isCompleted(), task.getCreatedAt());
	}

	@PatchMapping("/{id}/complete")
	public TaskResponse markComplete(@PathVariable Long id){
		Task task = repo.findById(id).orElseThrow( () -> new NotFoundException("Task with id "+ id + " not found"));

		if( !task.isCompleted()){
			task.setCompleted(true);
			task = repo.save(task);

		}
		return toResponse(task);
	}

	@PatchMapping("/{id}")
	public TaskResponse updateTitle(@PathVariable Long id, @Valid @RequestBody UpdateTaskRequest request){
		Task task = repo.findById(id).orElseThrow( () -> new NotFoundException("Task with id "+id+" not found"));
		//Change the title
		task.setTitle(request.title());
		task = repo.save(task);

		return toResponse(task);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)

	public void delete(@PathVariable Long id){
		Task task = repo.findById(id).orElseThrow( () -> new NotFoundException("task with " + id +" not Found"));

		repo.delete(task);
	}
}
