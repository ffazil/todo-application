package com.tracebucket.x.todo.domain.event;

public class TaskTitleModifiedEvent implements TaskEvent {

	private final String id;
	
	private final String title;

    public TaskTitleModifiedEvent(String id, String title) {
        this.id = id;
        this.title = title;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
