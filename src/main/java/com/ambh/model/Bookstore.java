package com.ambh.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(namespace = "http://ambh.com/examples/jaxb")
@XmlType(propOrder = {"name", "location", "bookList"})
public class Bookstore {

    private List<Book> bookList;
    private String name;
    private String location;

    public Bookstore() {
    }

    @XmlElement(name = "book")
    @XmlElementWrapper(name = "booklist")
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
