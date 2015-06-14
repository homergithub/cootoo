package com.cootoo.common.exception;

public class DataFormatException extends Exception{

	private static final long serialVersionUID = -3660061932541310437L;

	public DataFormatException() {
		super();
	}

	public DataFormatException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataFormatException(String message) {
		super(message);
	}

	public DataFormatException(Throwable cause) {
		super(cause);
	}

}
