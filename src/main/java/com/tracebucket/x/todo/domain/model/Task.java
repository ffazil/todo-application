package com.tracebucket.x.todo.domain.model;

import com.tracebucket.x.todo.domain.command.*;
import com.tracebucket.x.todo.domain.event.*;
import com.tracebucket.x.todo.domain.exception.TaskAlreadyCompletedException;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.repository.Repository;

import javax.validation.constraints.NotNull;

public class Task extends AbstractAnnotatedAggregateRoot<String> {

	private Repository<Task> taskRepository;

	/**
	 * The constant serialVersionUID 
	 */
	private static final long serialVersionUID = -5977984483620451665L;
	
	@AggregateIdentifier
	private String id;
	
	@NotNull
	private boolean completed;
	
	public Task(String id, String username, String title) {
        apply(new TaskCreatedEvent(id, username, title));
	}
	
	Task() {
	}

	public void complete(){
        apply(new TaskCompletedEvent(this.id));
    }
	
	public void star() {
		apply(new TaskStarredEvent(this.id));
	}
	
	public void unstar() {
		apply(new TaskUnstarredEvent(this.id));
	}
	
	public void changeTitle(String newTitle) {
		assertNotCompleted();
		apply(new TaskTitleModifiedEvent(this.id, newTitle));
	}
	
	@EventHandler
	void on(TaskCreatedEvent event) {
		this.id = event.getId();
	}

    @EventHandler
    void on(TaskCompletedEvent event) {
        this.completed = true;
    }

	private void assertNotCompleted() {
		if (completed) {
			throw new TaskAlreadyCompletedException("Task [ identifier = " + id + " ] is completed.");
		}		
	}
}
