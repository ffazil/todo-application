package com.tracebucket.x.todo.query.repository;

import com.tracebucket.x.todo.query.model.TaskEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskEntryRepository extends CrudRepository<TaskEntry, String> {
	List<TaskEntry> findByUsernameAndCompleted(String username, boolean completed);
}
