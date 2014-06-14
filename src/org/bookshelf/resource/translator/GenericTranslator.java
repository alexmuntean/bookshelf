package org.bookshelf.resource.translator;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericTranslator<Model, Dto> {
	public abstract Dto convert(Model model);

	public abstract Model updateModel(Dto dto, Model model);

	public List<Dto> convertList(List<Model> models) {
		List<Dto> dtos = new ArrayList<>();
		for (Model model : models) {
			dtos.add(convert(model));
		}
		return dtos;
	}
}
