package org.bookshelf.backend.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bookshelf.backend.entity.Category;

@Stateless
public class CategoryDao extends GenericDao<Category> {
	@PersistenceContext(unitName = "bookshelf")
	private EntityManager em;

	public CategoryDao() {
		super(Category.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
