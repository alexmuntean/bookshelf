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

import org.bookshelf.backend.entity.History;
import org.bookshelf.backend.service.HistoryService;
import org.bookshelf.client.entity.HistoryDto;
import org.bookshelf.resource.translator.HistoryTranslator;

@ApplicationScoped
@Path("/histories")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class HistoryResource {
	@Inject
	private HistoryService service;
	@Inject
	private HistoryTranslator translator;

	@GET
	@Path("/")
	public Response list() {
		List<History> histories = service.getAll();
		return Response.status(200).entity(translator.convertList(histories)).build();
	}

	@POST
	@Path("/")
	public Response create(HistoryDto historyDto) {
		History history = translator.updateModel(historyDto, new History());

		History createdHistory = service.create(history);

		return Response.status(200).entity(translator.convert(createdHistory)).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		History history = service.getById(id);
		return Response.status(200).entity(translator.convert(history)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, HistoryDto historyDto) {
		History updatedHistory = service.update(historyDto);

		return Response.status(200).entity(translator.convert(updatedHistory)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		service.delete(id);
		return Response.status(204).build();
	}
}
