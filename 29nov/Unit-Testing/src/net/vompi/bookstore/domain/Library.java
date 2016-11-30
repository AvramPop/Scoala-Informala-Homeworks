package net.vompi.bookstore.domain;

import net.vompi.bookstore.data.Book;
import net.vompi.bookstore.data.Client;

import java.util.List;

/**
 * Created by dani on 11/29/16.
 */
public interface Library {
    void register(Client newClient);

    List<Book> showAllBooks();

    List<Book> findByTitle(String title);

    void lend(Book book, Client client);
}
