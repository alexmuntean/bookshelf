package org.bookshelf.backend.exception;

public abstract class BookshelfException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public abstract Integer getStatus();

	public abstract String getCode();

	public abstract String getMessages();
}
