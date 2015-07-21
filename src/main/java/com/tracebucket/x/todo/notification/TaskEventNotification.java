package com.tracebucket.x.todo.notification;

import com.tracebucket.x.todo.domain.event.TaskEvent;

public class TaskEventNotification {
	
	private String type;
	
	private TaskEvent data;

	public TaskEventNotification(String type, TaskEvent data) {
		this.type = type;
		this.data = data;
	}

    public String getType() {
        return type;
    }

    public TaskEvent getData() {
        return data;
    }
}
