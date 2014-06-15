package org.bookshelf.backend.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.bookshelf.backend.dao.UserDao;
import org.bookshelf.backend.entity.User;
import org.bookshelf.backend.exception.EntityNotFoundException;
import org.bookshelf.client.entity.UserDto;
import org.bookshelf.resource.translator.UserTranslator;

@Stateless
public class UserService {
	@Inject
	private UserDao dao;
	@Inject
	private UserTranslator translator;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public User create(User User) {
		return dao.create(User);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User update(UserDto userDto) {
		User user = getById(userDto.getId());
		translator.updateModel(userDto, user);
		return dao.update(user);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public User getById(Integer id) {
		if (dao.getById(id) == null) {
			throw new EntityNotFoundException("User[" + id + "]");
		}
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<User> getAll() {
		return dao.getAll();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
