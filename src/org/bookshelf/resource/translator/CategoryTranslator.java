package org.bookshelf.resource.translator;

import org.bookshelf.backend.entity.Category;
import org.bookshelf.client.entity.CategoryDto;

public class CategoryTranslator extends GenericTranslator<Category, CategoryDto> {
	
	@Override
	public CategoryDto convert(Category model) {
		if(model==null) return null;
		return new CategoryDto(model.getId(), model.getName());
	}

	@Override
	public Category updateModel(CategoryDto dto, Category model) {
		model.setName(dto.getName());
		return model;
	}
}
