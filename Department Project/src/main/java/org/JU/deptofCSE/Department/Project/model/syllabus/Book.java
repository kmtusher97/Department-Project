package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "book")
public class Book {

    private String bookName;

    private Authors authors;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
