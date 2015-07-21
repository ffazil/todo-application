package com.tracebucket.x.todo.rest.resource;

import javax.validation.constraints.NotNull;

public class ModifyTitleRequest {
	
	@NotNull
	private String title;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
