package org.bookshelf.client.entity;

public class HistoryDto {
	private Integer id;
	private UserDto user;
	private BookDto book;
	private String operation;
	private String notes;
	
	public HistoryDto() {
	}

	public HistoryDto(Integer id, UserDto user, BookDto book, String operation, String notes) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.operation = operation;
		this.notes = notes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book= book;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
