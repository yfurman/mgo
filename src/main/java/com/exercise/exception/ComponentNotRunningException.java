package com.exercise.exception;

public class ComponentNotRunningException extends RuntimeException {
	private ErrorCode errorCode;
	
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
