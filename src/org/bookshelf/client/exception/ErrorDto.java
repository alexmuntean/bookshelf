package org.bookshelf.client.exception;

public class ErrorDto {
	private String code;
	private String message;

	public ErrorDto(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
