package com.tracebucket.x.todo.domain.command;

import javax.validation.constraints.NotNull;

public class CreateTaskCommand {

	@NotNull
	private final String id;
	
	@NotNull
	private final String username;
	
	@NotNull
	private final String title;

    public CreateTaskCommand(String id, String username, String title) {
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
