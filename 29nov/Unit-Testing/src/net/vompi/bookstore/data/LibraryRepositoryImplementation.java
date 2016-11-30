package net.vompi.bookstore.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 11/29/16.
 */
public class LibraryRepositoryImplementation implements LibraryRepository {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Client> clients = new ArrayList<Client>();

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void addBook(Book newBook) {
        books.add(book);
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }
}
