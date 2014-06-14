package org.bookshelf.backend.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bookshelf.backend.entity.User;

@Stateless
public class UserDao extends GenericDao<User> {
	@PersistenceContext(unitName = "bookshelf")
	private EntityManager em;

	public UserDao() {
		super(User.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
