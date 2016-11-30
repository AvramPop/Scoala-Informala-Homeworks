package net.vompi.bookstore.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 11/29/16.
 */
public interface LibraryRepository {
    void addBook(Book newBook);
    void removeBook(Book book);
    void addClient(Client client);
    void removeClient(Client client);
    List<Client> getAllClients();
}
