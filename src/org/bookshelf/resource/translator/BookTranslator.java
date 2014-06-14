package org.bookshelf.resource.translator;

import javax.inject.Inject;

import org.bookshelf.backend.entity.Book;
import org.bookshelf.backend.service.CategoryService;
import org.bookshelf.client.entity.BookDto;

public class BookTranslator extends GenericTranslator<Book, BookDto> {
	@Inject
	private CategoryTranslator categoryTranslator;
	@Inject
	private CategoryService categoryService;
	
	@Override
	public BookDto convert(Book model) {
		return new BookDto(
				model.getId(),
				model.getTitle(), 
				model.getIsbn(),
				model.getAuthor(),
				model.getStatus(),
				categoryTranslator.convert(model.getCategory()));
	}

	@Override
	public Book updateModel(BookDto dto, Book model) {
		model.setTitle(dto.getTitle());
		model.setIsbn(dto.getIsbn());
		model.setAuthor(dto.getAuthor());
		model.setStatus(dto.getStatus());
		if(dto.getCategory()!=null) {
			model.setCategory(categoryService.getById(dto.getCategory().getId()));
		}
		return model;
	}
}
