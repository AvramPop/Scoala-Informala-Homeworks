package net.vompi.bookstore.domain;

import net.vompi.bookstore.data.Book;
import net.vompi.bookstore.data.Client;
import net.vompi.bookstore.data.LibraryRepository;

import java.util.List;

/**
 * Created by dani on 11/29/16.
 */
public class LibraryImplementation implements Library {
    private LibraryRepository libraryRepository;

    @Override
    public void register(Client newClient) {
        List<Client> clients = libraryRepository.getAllCLients();
        if(clients.contains(newClient)) {
            throw new IllegalArgumentException("Client already registered!");
        }
        LibraryRepository.addClient(newClient);
    }

    @Override
    public List<Book> showAllBooks() {
        return null;
    }

    @Override
    public List<Book> findByTitle(Strin title) {
        return null;
    }

    @Override
    public void lend(Book book, Client client) {

    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }
}
