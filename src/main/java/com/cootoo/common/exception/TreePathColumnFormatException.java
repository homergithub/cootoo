package com.cootoo.common.exception;

public class TreePathColumnFormatException extends DataFormatException{

	private static final long serialVersionUID = 8567462835234091968L;

	public TreePathColumnFormatException() {
		super();
	}

	public TreePathColumnFormatException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TreePathColumnFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public TreePathColumnFormatException(String message) {
		super(message);
	}

	public TreePathColumnFormatException(Throwable cause) {
		super(cause);
	}

}
