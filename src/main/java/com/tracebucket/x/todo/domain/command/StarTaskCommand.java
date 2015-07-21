package com.tracebucket.x.todo.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class StarTaskCommand {

	@TargetAggregateIdentifier
	private final String id;

    public StarTaskCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
