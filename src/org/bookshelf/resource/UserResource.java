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

import org.bookshelf.backend.entity.User;
import org.bookshelf.backend.service.UserService;
import org.bookshelf.client.entity.UserDto;
import org.bookshelf.resource.translator.UserTranslator;

@ApplicationScoped
@Path("/users")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserResource {
	@Inject
	private UserService service;
	@Inject
	private UserTranslator translator;

	@GET
	@Path("/")
	public Response list() {
		List<User> users = service.getAll();
		return Response.status(200).entity(translator.convertList(users)).build();
	}

	@POST
	@Path("/")
	public Response create(UserDto userDto) {
		User user = translator.updateModel(userDto, new User());
		
		User createdUser = service.create(user);
		
		return Response.status(200).entity(translator.convert(createdUser)).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		User user = service.getById(id);
		return Response.status(200).entity(translator.convert(user)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, UserDto userDto) {
		User user = translator.updateModel(userDto, service.getById(id));
		
		User updatedUser = service.update(user);
		
		return Response.status(200).entity(translator.convert(updatedUser)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		service.delete(id);
		return Response.status(204).build();
	}
}
