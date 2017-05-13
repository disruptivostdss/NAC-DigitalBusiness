package br.com.fiap.exception;

public class WebServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6573610399435849646L;

	public WebServiceException() {
		super();
	}

	public WebServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebServiceException(String message) {
		super(message);
	}

	public WebServiceException(Throwable cause) {
		super(cause);
	}

}