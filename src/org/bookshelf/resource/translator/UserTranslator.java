package org.bookshelf.resource.translator;

import org.bookshelf.backend.entity.User;
import org.bookshelf.client.entity.UserDto;

public class UserTranslator extends GenericTranslator<User, UserDto> {

	@Override
	public UserDto convert(User model) {
		return new UserDto(
				model.getId(), 
				model.getName(), 
				model.getDescription(), 
				model.getPosition(), 
				model.getEmail(), 
				model.getRole(),
				model.getPassword());
	}

	@Override
	public User updateModel(UserDto dto, User model) {
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPosition(dto.getPosition());
		model.setEmail(dto.getEmail());
		model.setRole(dto.getRole());
		model.setPassword(dto.getPassword());
		return model;
	}

}
