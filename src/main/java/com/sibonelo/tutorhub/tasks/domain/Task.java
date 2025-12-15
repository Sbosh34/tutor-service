package com.sibonelo.tutorhub.tasks.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tasks")

public class Task{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 120)
	private String title;

	@Column(nullable = false)
	private boolean completed = false;

	@Column(nullable = false, updatable = false)
	private Instant createdAt =  Instant.now();
	
	//no-arg contructor required by springboot
	protected Task(){}

	public Task(String title){
		this.title = title;

	}
	public Long getId(){ return id;}

	public String getTitle(){ return title;}

	public boolean isCompleted(){ return completed;}

	public void setCompleted( boolean completed ){ this.completed = completed; }
	public Instant getCreatedAt(){
	 return createdAt;}
}
