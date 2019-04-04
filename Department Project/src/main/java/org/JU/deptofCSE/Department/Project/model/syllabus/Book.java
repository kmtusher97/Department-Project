package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Book")
public class Book {

    @XmlElement(name = "BookName")
    private String bookName;

    @XmlElement(name = "Authors")
    private Authors authors;

    public String get_BookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Authors get_Authors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authors=" + authors +
                '}';
    }
}
