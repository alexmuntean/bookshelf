package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.CategoryDao;
import org.bookshelf.backend.entity.Category;
import org.bookshelf.backend.exception.EntityNotFoundException;
import org.bookshelf.client.entity.CategoryDto;
import org.bookshelf.resource.translator.CategoryTranslator;

@Stateless
public class CategoryService {
	@Inject
	private CategoryDao dao;
	@Inject
	private CategoryTranslator translator;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Category create(Category category) {
		return dao.create(category);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Category update(CategoryDto categoryDto) {
		Category category = getById(categoryDto.getId());
		translator.updateModel(categoryDto, category);
		return dao.update(category);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Category getById(Integer id) {
		Category entity = dao.getById(id);

		if (entity == null) {
			throw new EntityNotFoundException("Category[" + id + "]");
		}
		
		return entity;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Category> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
