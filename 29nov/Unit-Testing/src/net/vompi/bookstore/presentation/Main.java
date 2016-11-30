package net.vompi.bookstore.presentation;

import net.vompi.bookstore.data.LibraryRepository;
import net.vompi.bookstore.data.LibraryRepositoryImplementation;
import net.vompi.bookstore.domain.*;

public class Main {

    public static void main(String[] args) {
        LibraryRepository libraryRepository = new LibraryRepositoryImplementation();
        //Library library = new LibraryImplementation(libraryRepository);
    }
}
