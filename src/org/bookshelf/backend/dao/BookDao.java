package org.bookshelf.backend.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bookshelf.backend.entity.Book;

@Stateless
public class BookDao extends GenericDao<Book> {
	@PersistenceContext(unitName = "bookshelf")
	private EntityManager em;

	public BookDao() {
		super(Book.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
