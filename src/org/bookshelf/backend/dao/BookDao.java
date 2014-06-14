package org.bookshelf.backend.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public List<Book> getAllByStatus(Integer status) {
		Query query = em.createQuery("SELECT b FROM Book b WHERE b.status=:status");
		query.setParameter("status", status);
		return (List<Book>) query.getResultList();
	}
}
