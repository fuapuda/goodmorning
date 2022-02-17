package com.example.website.ex;

/**
 * 更新操作是出现的异常
 * 无法描述原因或特殊情况时出现异常
 */
public class UpdateException extends ServiceException {
	public UpdateException() {
		super();
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(String message) {
		super(message);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}
}
