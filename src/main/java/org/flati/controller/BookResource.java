package org.flati.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.flati.model.Book;
import org.flati.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookRepository bookRepository;

    @Inject
    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getBookCount() {
        return getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBookById(@PathParam("id") int id) {
        return bookRepository.findById(id);
    }

}
