package com.sibonelo.tutorhub.tasks.repo;

import com.sibonelo.tutorhub.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
}
