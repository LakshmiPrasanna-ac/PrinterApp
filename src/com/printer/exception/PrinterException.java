package com.printer.exception;

public class PrinterException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrinterException(String message) {
		super(message);
	}
	
	public PrinterException(String message, Throwable cause) {
		super(message, cause);
	}
}
