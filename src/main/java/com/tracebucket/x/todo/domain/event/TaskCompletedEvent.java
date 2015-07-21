package com.tracebucket.x.todo.domain.event;

public class TaskCompletedEvent implements TaskEvent {

	private final String id;

    public TaskCompletedEvent(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
