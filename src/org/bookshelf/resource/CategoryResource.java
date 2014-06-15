package org.bookshelf.resource;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bookshelf.backend.entity.Category;
import org.bookshelf.backend.service.CategoryService;
import org.bookshelf.client.entity.CategoryDto;
import org.bookshelf.resource.translator.CategoryTranslator;

@ApplicationScoped
@Path("/categories")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CategoryResource {
	@Inject
	private CategoryService service;
	@Inject
	private CategoryTranslator translator;

	@GET
	@Path("/")
	public Response list() {
		List<Category> categories = service.getAll();
		return Response.status(200).entity(translator.convertList(categories)).build();
	}

	@POST
	@Path("/")
	public Response create(CategoryDto categoryDto) {
		Category category = translator.updateModel(categoryDto, new Category());
		
		Category createdCategory = service.create(category);
		
		return Response.status(200).entity(translator.convert(createdCategory)).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		Category category = service.getById(id);
		return Response.status(200).entity(translator.convert(category)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, CategoryDto categoryDto) {
		Category updatedCategory = service.update(categoryDto);
		
		return Response.status(200).entity(translator.convert(updatedCategory)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		service.delete(id);
		return Response.status(204).build();
	}
}
