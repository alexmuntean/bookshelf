package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.HistoryDao;
import org.bookshelf.backend.entity.History;
import org.bookshelf.backend.exception.EntityNotFoundException;
import org.bookshelf.client.entity.HistoryDto;
import org.bookshelf.resource.translator.HistoryTranslator;

@Stateless
public class HistoryService {
	@Inject
	private HistoryDao dao;
	@Inject
	private HistoryTranslator translator;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public History create(History History) {
		return dao.create(History);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public History update(HistoryDto historyDto) {
		History history = getById(historyDto.getId());
		translator.updateModel(historyDto, history);
		return dao.update(history);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public History getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("History[" + id + "]");
		}
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<History> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
