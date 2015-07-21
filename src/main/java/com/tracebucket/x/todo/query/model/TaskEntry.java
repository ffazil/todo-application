package com.tracebucket.x.todo.query.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "tasks", type = "entry")
public class TaskEntry {

	@Id
	private String id;
	
	private String username;
	
	private String title;
	
	private boolean completed;
	
	private boolean starred;

	public TaskEntry(){

    }

    public TaskEntry(String id, String username, String title, boolean completed, boolean starred) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.completed = completed;
        this.starred = starred;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
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

    public boolean isCompleted() {
        return completed;
    }

    public boolean isStarred() {
        return starred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntry taskEntry = (TaskEntry) o;

        if (completed != taskEntry.completed) return false;
        if (starred != taskEntry.starred) return false;
        if (!id.equals(taskEntry.id)) return false;
        if (!username.equals(taskEntry.username)) return false;
        return title.equals(taskEntry.title);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (completed ? 1 : 0);
        result = 31 * result + (starred ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskEntry{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", starred=" + starred +
                '}';
    }
}