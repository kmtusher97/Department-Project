package org.JU.deptofCSE.Department.Project.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RestController
@RequestMapping(value = "/syl")
public class SyllabusController {

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
}
