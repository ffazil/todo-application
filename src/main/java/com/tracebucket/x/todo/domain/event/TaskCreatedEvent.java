package com.tracebucket.x.todo.domain.event;

public class TaskCreatedEvent implements TaskEvent {

	private final String id;
	
	private final String username;
	
	private final String title;

    public TaskCreatedEvent(String id, String username, String title) {
        this.id = id;
        this.username = username;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }
}
