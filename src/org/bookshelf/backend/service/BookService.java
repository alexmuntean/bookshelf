package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.BookDao;
import org.bookshelf.backend.entity.Book;
import org.bookshelf.backend.exception.EntityNotFoundException;
import org.bookshelf.client.entity.BookDto;
import org.bookshelf.resource.translator.BookTranslator;

@Stateless
public class BookService {
	@Inject
	private BookDao dao;
	@Inject
	private BookTranslator translator;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Book create(Book book) {
		return dao.create(book);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Book update(BookDto bookDto) {
		Book book = getById(bookDto.getId());
		translator.updateModel(bookDto, book);
		return dao.update(book);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Book getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("book[" + id + "]");
		}
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Book> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Book> getAll(Integer status) {
		if (status == null) {
			return dao.getAll();
		}
		return dao.getAllByStatus(status);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
