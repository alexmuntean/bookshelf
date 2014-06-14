package org.bookshelf.resource.translator;

import javax.inject.Inject;

import org.bookshelf.backend.entity.History;
import org.bookshelf.backend.service.BookService;
import org.bookshelf.backend.service.UserService;
import org.bookshelf.client.entity.HistoryDto;

public class HistoryTranslator extends GenericTranslator<History, HistoryDto> {
	@Inject
	private UserTranslator userTranslator;
	@Inject
	private BookTranslator bookTranslator;
	@Inject
	private UserService userService;
	@Inject
	private BookService bookService;
	
	@Override
	public HistoryDto convert(History model) {
		return new HistoryDto(
				model.getId(), 
				userTranslator.convert(model.getUser()),
				bookTranslator.convert(model.getBook()), 
				model.getOperation(),
				model.getNotes());
	}

	@Override
	public History updateModel(HistoryDto dto, History model) {
		model.setOperation(dto.getOperation());
		model.setNotes(dto.getNotes());
		model.setUser(userService.getById(dto.getUser().getId()));
		model.setBook(bookService.getById(dto.getBook().getId()));
		
		return model;
	}

}
