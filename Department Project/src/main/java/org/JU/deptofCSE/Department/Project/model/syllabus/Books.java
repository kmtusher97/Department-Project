package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "Books")
public class Books implements Serializable {

    @XmlElement(name = "Book")
    private List<Book> bookList;

    public List<Book> getBooks() {
        return bookList;
    }

    public void setBooks(List<Book> books) {
        this.bookList = books;
    }
}
