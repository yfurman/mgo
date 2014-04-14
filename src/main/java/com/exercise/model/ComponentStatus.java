package com.exercise.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.http.HttpStatus;

public class ComponentStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8700235225747503213L;
	
	private String component;
	private HttpStatus status;
	
	@JsonCreator
	public ComponentStatus(@JsonProperty("component") String component,
						   @JsonProperty("status") HttpStatus status) {
		this.setComponent(component);
		this.setStatus(status);
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
