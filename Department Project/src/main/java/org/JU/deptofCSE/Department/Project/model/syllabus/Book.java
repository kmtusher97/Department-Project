package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Book")
public class Book {

    private String bookName;

    private String authorsString;

    private List<String> authors;

    private String edition;

    private String publisher;

    private String publishYear;

    public Book() {
    }

    public Book(String bookName, String authorsString, List<String> authors, String edition, String publisher, String publishYear) {
        this.bookName = bookName;
        this.authorsString = authorsString;
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

    public String getAuthorsString() {
        return authorsString;
    }

    public void setAuthorsString(String authorsString) {
        this.authorsString = authorsString;
    }

    @XmlElement(name = "Author")
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void makeAuthorList() {
        String[] authorList = authorsString.split(",");
        if(this.authors == null) {
            this.authors = new ArrayList<String>();
        }
        for(String s : authorList) {
            this.authors.add(s);
        }
    }

    public void addAuthor(String author) {
        if(this.authors == null) {
            this.authors = new ArrayList<String>();
        }
        this.authors.add(author);
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
                ", authorsString='" + authorsString + '\'' +
                ", authors=" + authors +
                ", edition='" + edition + '\'' +
                ", publishYear='" + publishYear + '\'' +
                '}';
    }
}
