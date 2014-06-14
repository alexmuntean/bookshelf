package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.CategoryDao;
import org.bookshelf.backend.entity.Category;
import org.bookshelf.backend.exception.EntityNotFoundException;

@Stateless
public class CategoryService {
	@Inject
	private CategoryDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Category create(Category Category) {
		return dao.create(Category);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Category update(Category Category) {
		return dao.update(Category);
	}

	public Category getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("Category[" + id + "]");
		}
		return dao.getById(id);
	}

	public List<Category> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
