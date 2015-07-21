package com.tracebucket.x.todo.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class UnstarTaskCommand {

	@TargetAggregateIdentifier
	private final String id;

    public UnstarTaskCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}