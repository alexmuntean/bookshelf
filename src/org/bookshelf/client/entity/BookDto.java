package org.bookshelf.client.entity;

public class BookDto {
	private Integer id;
	private String title;
	private String isbn;
	private String author;
	private Integer status;
	private CategoryDto category;
	
	public BookDto() {
	}

	public BookDto(Integer id, String title, String isbn, String author, Integer status, CategoryDto category) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.status = status;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategoryDto(CategoryDto category) {
		this.category = category;
	}
}
