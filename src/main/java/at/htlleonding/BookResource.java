package at.htlleonding;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.HashSet;
import java.util.Set;

@Path("/books")
public class BookResource {
    private Set<Book> books = new HashSet<>();

    public BookResource() {
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Set<Book> get() {
        return books;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Book> add(Book book) {
        System.out.println("Added book: " + book.getTitle());
        books.add(book);
        return books;
    }
}
