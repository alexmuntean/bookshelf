package org.bookshelf.backend.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.bookshelf.backend.exception.BookshelfException;

@Provider
public class BookshelfExceptionMapper implements ExceptionMapper<BookshelfException> {
	@Override
	public Response toResponse(BookshelfException exception) {
		return Response.status(exception.getStatus()).entity(exception.getMessages()).build();
	}
}