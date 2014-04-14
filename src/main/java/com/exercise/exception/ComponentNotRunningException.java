package com.exercise.exception;

public class ComponentNotRunningException extends RuntimeException {
	private ErrorCode errorCode;
	
	public ComponentNotRunningException(ErrorCode erroCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
