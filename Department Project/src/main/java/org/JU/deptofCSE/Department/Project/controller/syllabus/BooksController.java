package org.JU.deptofCSE.Department.Project.controller.syllabus;


import org.JU.deptofCSE.Department.Project.model.syllabus.Book;
import org.JU.deptofCSE.Department.Project.model.syllabus.Books;
import org.JU.deptofCSE.Department.Project.service.syllabus.BooksServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    /*//@Autowired(required = true)
    BooksServices booksServices = new BooksServices();

    @RequestMapping(value = "/save")
    public void addBooks() throws JAXBException {
        Books books = new Books();
        Book book = new Book();
        book.setBookName("Competitive Programming");
        Authors authors = new Authors();
        List<String> al = new ArrayList<String>();
        al.add("Felix");
        al.add("Halim");
        authors.setAuthor(al);
        book.setAuthors(authors);

        List<Book> l1 = new ArrayList<Book>();
        l1.add(book);
        l1.add(book);
        l1.add(book);
        books.setBooks(l1);
        booksServices.saveBooks(books);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Books getBooks() throws JAXBException {
        Books books = booksServices.getBooks();
        System.err.println(books);
        return books;
    }*/
}
