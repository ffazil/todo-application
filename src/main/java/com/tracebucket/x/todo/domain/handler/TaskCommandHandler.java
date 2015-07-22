package com.tracebucket.x.todo.domain.handler;

import com.tracebucket.x.todo.domain.command.*;
import com.tracebucket.x.todo.domain.model.Task;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ffazil
 * @since 22/07/15
 */
@Component
public class TaskCommandHandler {


    @Autowired
    private Repository<Task> taskRepository;

    @CommandHandler
    public void createTask(CreateTaskCommand command){
        Task task = new Task(command.getId(), command.getUsername(), command.getTitle());
        taskRepository.add(task);
    }

    @CommandHandler
    public void completeTask(CompleteTaskCommand command){
        Task task = taskRepository.load(command.getId());
        task.complete();
    }

    @CommandHandler
    public void starTask(StarTaskCommand command){
        Task task = taskRepository.load(command.getId());
        task.star();
    }

    @CommandHandler
    public void unstarTask(UnstarTaskCommand command){
        Task task = taskRepository.load(command.getId());
        task.unstar();
    }

    @CommandHandler
    public void changeTaskTitle(ModifyTaskTitleCommand command){
        Task task = taskRepository.load(command.getId());
        task.changeTitle(command.getTitle());
    }
}
