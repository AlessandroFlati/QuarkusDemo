package org.flati.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.flati.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1, "Book 1", "Author 1", "Publisher 1", 100));
        books.add(new Book(2, "Book 2", "Author 2", "Publisher 2", 200));
    }

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(int id) {
        return books.stream().filter(book -> book.id() == id).findFirst();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(int id, Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id() == id) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.id() == id);
    }

    public int count() {
        return books.size();
    }

    public void clear() {
        books.clear();
    }

    public void addBooks(List<Book> newBooks) {
        books.addAll(newBooks);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeAllBooks() {
        books.clear();
    }

    public boolean containsBook(Book book) {
        return books.contains(book);
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.author().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.publisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }
}
