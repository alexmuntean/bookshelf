package org.bookshelf.resource.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.bookshelf.backend.exception.BookshelfException;
import org.bookshelf.client.exception.ErrorDto;

@Provider
public class BookshelfExceptionMapper implements ExceptionMapper<BookshelfException> {
	@Override
	public Response toResponse(BookshelfException exception) {
		Integer status = exception.getStatus();
		ErrorDto errorDto = new ErrorDto(exception.getCode(), exception.getMessages());
		return Response.status(status).entity(errorDto).build();
	}
}