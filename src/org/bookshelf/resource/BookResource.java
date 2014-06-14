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

import org.bookshelf.backend.entity.Book;
import org.bookshelf.backend.service.BookService;
import org.bookshelf.client.entity.BookDto;
import org.bookshelf.resource.translator.BookTranslator;

@ApplicationScoped
@Path("/books")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BookResource {
	@Inject
	private BookService service;
	@Inject
	private BookTranslator translator;

	@GET
	@Path("/")
	public Response list() {
		List<Book> books = service.getAll();
		return Response.status(200).entity(translator.convertList(books)).build();
	}

	@POST
	@Path("/")
	public Response create(BookDto bookDto) {
		Book book = translator.updateModel(bookDto, new Book());
		
		Book createdBook = service.create(book);
		
		return Response.status(200).entity(translator.convert(createdBook)).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		Book book = service.getById(id);
		return Response.status(200).entity(translator.convert(book)).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Integer id, BookDto bookDto) {
		Book book = translator.updateModel(bookDto, service.getById(id));
		
		Book updatedBook = service.update(book);
		
		return Response.status(200).entity(translator.convert(updatedBook)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		service.delete(id);
		return Response.status(204).build();
	}
}
