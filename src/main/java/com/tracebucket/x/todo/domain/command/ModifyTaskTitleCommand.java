package com.tracebucket.x.todo.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public class ModifyTaskTitleCommand {

	@TargetAggregateIdentifier
	private final String id;

	@NotNull
	private final String title;

    public ModifyTaskTitleCommand(String id, String title) {
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

