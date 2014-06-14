package org.bookshelf.backend.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bookshelf.backend.entity.History;

@Stateless
public class HistoryDao extends GenericDao<History> {
	@PersistenceContext(unitName = "bookshelf")
	private EntityManager em;

	public HistoryDao() {
		super(History.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
