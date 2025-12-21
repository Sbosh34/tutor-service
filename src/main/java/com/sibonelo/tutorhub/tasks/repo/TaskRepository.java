package com.sibonelo.tutorhub.tasks.repo;

import com.sibonelo.tutorhub.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	Page<Task> findByCompleted(boolean completed, Pageable pageable);
}
