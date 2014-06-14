package org.bookshelf.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<T> {
	private final Class<T> persistentClass;

	public GenericDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	protected Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected abstract EntityManager getEntityManager();

	public T create(T entity) {
		EntityManager em = getEntityManager();

		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	public T update(T entity) {
		EntityManager em = getEntityManager();

		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	public T getById(Integer id) {
		return (T) getEntityManager().find(getPersistentClass(), id);
	}

	public List<T> getAll() {
		CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(persistentClass);
		criteriaQuery.from(persistentClass);
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}

	public List<T> getAll(Integer limit, Integer page) {
		CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(persistentClass);
		criteriaQuery.from(persistentClass);
		return getEntityManager().createQuery(criteriaQuery).setFirstResult((page - 1) * limit).setMaxResults(limit).getResultList();
	}

	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	public void deleteById(Integer id) {
		T entity = this.getById(id);
		if (entity != null) {
			getEntityManager().remove(entity);
		}
	}
}
