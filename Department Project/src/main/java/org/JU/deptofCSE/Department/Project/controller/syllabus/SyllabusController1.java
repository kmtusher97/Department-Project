package org.JU.deptofCSE.Department.Project.controller.syllabus;


import org.JU.deptofCSE.Department.Project.model.syllabus.Authors;
import org.JU.deptofCSE.Department.Project.model.syllabus.Book;
import org.JU.deptofCSE.Department.Project.model.syllabus.Books;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RestController
@RequestMapping(value = "/syl")
public class SyllabusController1 {

   /* @RequestMapping(value = "/book")
    public String test() throws JAXBException, FileNotFoundException {
        List<Book> books;
        Book book = new Book();
        book.setName("reersfsf");
        List<String> lst = new ArrayList<String>();
        lst.add("1");
        lst.add("2");
        book.setAuthor(lst);
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(book, new File("books1.xml"));
        marshaller.marshal(book, System.out);
        return "okkk";
    }*/

    /*@RequestMapping(value = "/books")
    public String test() throws JAXBException, FileNotFoundException {
        *//*Book book1 = new Book();
        book1.setBookName("Competitive Programming");
        List<Authors> lst = new ArrayList<Authors>();
        Authors a = new Authors();
        a.setAuthorName("Felix");
        lst.add(a);
        a.setAuthorName("Halim");
        lst.add(a);
        book1.setAuthors(lst);*//*

        Authors authors = new Authors();
        List<String> al = new ArrayList<String>();
        al.add("Felix");
        al.add("Halim");
        authors.setAuthor(al);

        JAXBContext jaxbContext = JAXBContext.newInstance(Authors.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(authors, new File("books1.xml"));
        marshaller.marshal(authors, System.out);
        return "okkk";
    }*/

    @RequestMapping(value = "/books")
    public String test() throws JAXBException {

        Book book = new Book();
        book.setBookName("Competitive Programming");
        Authors authors = new Authors();
        List<String> al = new ArrayList<String>();
        al.add("Felix");
        al.add("Halim");
        authors.setAuthor(al);
        book.setAuthors(authors);

        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(book, new File("books1.xml"));
        marshaller.marshal(book, System.out);
        return "okkk";
    }

    @RequestMapping(value = "/rd")
    public String test1() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("books1.xml");
        Book book = (Book) unmarshaller.unmarshal(file);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "book1.xml");
        marshaller.marshal(book, System.out);
        System.err.println(book);
        return "okkk";
    }

    @RequestMapping(value = "/bookall")
    public String test2() throws JAXBException {

        Book book = new Book();
        book.setBookName("Competitive Programming");
        Authors authors = new Authors();
        List<String> al = new ArrayList<String>();
        al.add("Felix");
        al.add("Halim");
        authors.setAuthor(al);
        book.setAuthors(authors);

        Books books = new Books();
        List<Book> l1 = new ArrayList<Book>();
        l1.add(book);
/*
        Book book1 = new Book();
        book1.setBookName("Programming Competition");
        al.clear();
        al.add("Mahbubul Hasan");
        authors.setAuthor(al);
        book1.setAuthors(authors);
        l1.add(book1);*/

        books.setBooks(l1);
        System.err.println(books);


        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(books, new File("books2.xml"));
        marshaller.marshal(books, System.out);
        return "okkk";
    }
}
