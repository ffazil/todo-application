package com.tracebucket.x.todo.domain.event;

public class TaskUnstarredEvent implements TaskEvent {

	private final String id;

	public TaskUnstarredEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
