package com.exercise.exception;

public class InvalidDirectoryException extends RuntimeException {
	private ErrorCode errorCode;
	
	public InvalidDirectoryException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
