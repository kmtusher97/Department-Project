package org.JU.deptofCSE.Department.Project.repository.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class BooksRepository {

    public void addBooks(Books books) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(books, new File("booksRp.xml"));
        marshaller.marshal(books, System.out);
    }

    public Books getBooks() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("booksRp.xml");
        Books books = (Books) unmarshaller.unmarshal(file);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return books;
    }
}
