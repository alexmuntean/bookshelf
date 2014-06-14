package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.BookDao;
import org.bookshelf.backend.entity.Book;
import org.bookshelf.backend.exception.EntityNotFoundException;

@Stateless
public class BookService {
	@Inject
	private BookDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Book create(Book book) {
		return dao.create(book);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Book update(Book book) {
		return dao.update(book);
	}

	public Book getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("book[" + id + "]");
		}
		return dao.getById(id);
	}

	public List<Book> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
