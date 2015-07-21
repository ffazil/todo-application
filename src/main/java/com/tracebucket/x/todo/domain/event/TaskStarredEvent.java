package com.tracebucket.x.todo.domain.event;

public class TaskStarredEvent implements TaskEvent {

	private final String id;

    public TaskStarredEvent(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
