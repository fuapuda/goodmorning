package com.example.website.ex;

/**
 * 招标信息不存在时抛出的异常
 */
public class BidInfoNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public BidInfoNotFoundException() {
		super();
	}

	public BidInfoNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BidInfoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BidInfoNotFoundException(String message) {
		super(message);
	}

	public BidInfoNotFoundException(Throwable cause) {
		super(cause);
	}

}
