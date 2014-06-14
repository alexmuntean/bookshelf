package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.HistoryDao;
import org.bookshelf.backend.entity.History;
import org.bookshelf.backend.exception.EntityNotFoundException;

@Stateless
public class HistoryService {
	@Inject
	private HistoryDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public History create(History History) {
		return dao.create(History);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public History update(History History) {
		return dao.update(History);
	}

	public History getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("History[" + id + "]");
		}
		return dao.getById(id);
	}

	public List<History> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
