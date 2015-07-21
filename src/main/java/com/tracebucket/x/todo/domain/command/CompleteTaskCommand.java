package com.tracebucket.x.todo.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;


public class CompleteTaskCommand {

	@TargetAggregateIdentifier
	private final String id;

    public CompleteTaskCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}