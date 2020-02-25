package com.learnreactivespring.playground;

public class CustomException extends Throwable {

	private static final long serialVersionUID = 3131658589391995145L;

	private String message;
	
	public CustomException(Throwable e) {
		this.message = e.getMessage();
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
