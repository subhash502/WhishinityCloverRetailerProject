package com.trendbrew.exception;

public class TbCloverException extends Exception {

	private static final long serialVersionUID = -4381121227551343957L;
	
	private String originalExceptionMessage;
	private String customMessage;
	
	public TbCloverException() {
		super();
	}
	
	public TbCloverException(String message, String customMessage) {
		super(message);
		this.originalExceptionMessage = message;
		this.customMessage = customMessage;
	}

	public String getOriginalExceptionMessage() {
		return originalExceptionMessage;
	}

	public void setOriginalExceptionMessage(String originalExceptionMessage) {
		this.originalExceptionMessage = originalExceptionMessage;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

}
