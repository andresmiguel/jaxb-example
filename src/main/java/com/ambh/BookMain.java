package com.ambh;

import com.ambh.model.Book;
import com.ambh.model.Bookstore;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookMain {

    private static final String BOOKSTORE_XML = "bookstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        ArrayList<Book> bookList = new ArrayList<>();

        createBooks(bookList);

        Bookstore bookstore = createBookstore(bookList);

        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(bookstore, System.out);

        marshaller.marshal(bookstore, new File(BOOKSTORE_XML));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Bookstore bookstore2 = (Bookstore) unmarshaller.unmarshal(new FileReader(BOOKSTORE_XML));


    }

    private static Bookstore createBookstore(ArrayList<Book> bookList) {
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Fraport Bookstore");
        bookstore.setLocation("Frankfurt Airport");
        bookstore.setBookList(bookList);
        return bookstore;
    }

    private static void createBooks(ArrayList<Book> bookList) {
        Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-3832180577");
        book2.setName("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        book2.setPublisher("Dumont Buchverlag");
        bookList.add(book2);
    }
}
