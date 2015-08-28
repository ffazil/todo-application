package com.tracebucket.x.todo.rest.controller;

import com.tracebucket.x.todo.domain.command.CompleteTaskCommand;
import com.tracebucket.x.todo.domain.command.CreateTaskCommand;
import com.tracebucket.x.todo.domain.command.ModifyTaskTitleCommand;
import com.tracebucket.x.todo.domain.command.StarTaskCommand;
import com.tracebucket.x.todo.query.model.TaskEntry;
import com.tracebucket.x.todo.query.repository.TaskEntryRepository;
import com.tracebucket.x.todo.rest.resource.CreateTaskRequest;
import com.tracebucket.x.todo.rest.resource.ModifyTitleRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.DefaultIdentifierFactory;
import org.axonframework.domain.IdentifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {

	private final IdentifierFactory identifierFactory = new DefaultIdentifierFactory();
	
	@Autowired
	private TaskEntryRepository taskEntryRepository;

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	private CommandGateway commandGateway;

	@RequestMapping(value = "/api/tasks", method = RequestMethod.GET)
	public @ResponseBody
	List<TaskEntry> findlAll(Principal principal, @RequestParam(required = false, defaultValue = "false") boolean completed, Pageable pageable) {
		return taskEntryRepository.findByUsernameAndCompleted(principal.getName(), completed);
	}

	@RequestMapping(value = "/api/tasks", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void createTask(Principal principal, @RequestBody @Valid CreateTaskRequest request) {
		commandGateway.send(new CreateTaskCommand(identifierFactory.generateIdentifier(), principal.getName(), request.getTitle()));
	}

	@RequestMapping(value = "/api/tasks/{identifier}/title", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void createTask(@PathVariable String identifier, @RequestBody @Valid ModifyTitleRequest request) {
		commandGateway.send(new ModifyTaskTitleCommand(identifier, request.getTitle()));
	}

	@RequestMapping(value = "/api/tasks/{identifier}/complete", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void createTask(@PathVariable String identifier) {
		commandGateway.send(new CompleteTaskCommand(identifier));
	}

	@RequestMapping(value = "/api/tasks/{identifier}/star", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void starTask(@PathVariable String identifier) {
		commandGateway.send(new StarTaskCommand(identifier));
	}

	@RequestMapping(value = "/api/tasks/{identifier}/unstar", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void unstarTask(@PathVariable String identifier) {
		throw new RuntimeException("Could not unstar task..."); 
		//commandGateway.sendAndWait(new UnstarTaskCommand(identifier));
	}

	@ExceptionHandler
	public void handleException(Principal principal, Throwable exception) {
		messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/errors", exception.getMessage());
	}

}