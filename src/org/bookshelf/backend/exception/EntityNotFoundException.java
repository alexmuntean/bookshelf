package org.bookshelf.backend.exception;

public class EntityNotFoundException extends BookshelfException {
	private static final long serialVersionUID = 1L;

	private String entity;

	public EntityNotFoundException(String entity) {
		this.entity = entity;
	}

	@Override
	public Integer getStatus() {
		return 404;
	}

	@Override
	public String getCode() {
		return "not found";
	}

	@Override
	public String getMessages() {
		return "requested" + entity + " not found";
	}

}
