package com.example.website.ex;

/**
 * 企业已存在时抛出的异常
 */
public class CompanyNameDuplicateException extends ServiceException {

	public CompanyNameDuplicateException() {
		super();
	}

	public CompanyNameDuplicateException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CompanyNameDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompanyNameDuplicateException(String message) {
		super(message);
	}

	public CompanyNameDuplicateException(Throwable cause) {
		super(cause);
	}
	
}
