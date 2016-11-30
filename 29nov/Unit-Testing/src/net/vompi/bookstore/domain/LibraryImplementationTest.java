package net.vompi.bookstore.domain;

import net.vompi.bookstore.data.Book;
import net.vompi.bookstore.data.Client;
import net.vompi.bookstore.data.LibraryRepository;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dani on 11/29/16.
 */
public class LibraryImplementationTest {
    public void whenClientExists_RegistrationFails(){
        //given
        Client client = new CLient();
        LibraryImplementation libraryImplementation = new LibraryImplementation(new OneClientRepo(client));
        LibraryImplementation.register(client);
    }

    private class OneClientRepo implements LibraryRepository {

        private Client client;

        public OneClientRepo(Client client) {
            this.client = client;
        }

        @Override
        public void addBook(Book newBook) {

        }

        @Override
        public void removeBook(Book book) {

        }

        @Override
        public void addClient(Client client) {
            throw new IllegalStateException();
        }

        @Override
        public void removeClient(Client client) {

        }

        @Override
        public List<Client> getAllClients() {

            return null;
        }
    }
}