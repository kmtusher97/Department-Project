package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Book")
public class Book {

    private String bookName;

    private String authors;

    private String edition;

    private String publisher;

    private String publishYear;

    public Book() {
        this.bookName = "";
        this.authors = "";
        this.edition = "";
        this.publisher = "";
        this.publishYear = "";
    }

    public Book(String bookName, String authors, String edition, String publisher, String publishYear) {
        this.bookName = bookName;
        this.authors = authors;
        this.edition = edition;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }

    @XmlElement(name = "BookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @XmlElement(name = "Authors")
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @XmlElement(name = "Edition")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @XmlElement(name = "Publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @XmlElement(name = "PublishYear")
    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authors='" + authors + '\'' +
                ", edition='" + edition + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishYear='" + publishYear + '\'' +
                '}';
    }
}
