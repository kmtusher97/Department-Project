package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Books;
import org.JU.deptofCSE.Department.Project.repository.syllabus.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;

public class BooksServices {

    //@Autowired(required = true)
    BooksRepository booksRepository = new BooksRepository();

    public void saveBooks(Books books) throws JAXBException {
        booksRepository.addBooks(books);
    }

    public Books getBooks() throws JAXBException {
        return booksRepository.getBooks();
    }
}
