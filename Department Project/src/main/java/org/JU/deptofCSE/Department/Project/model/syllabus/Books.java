package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Books")
public class Books implements Serializable {

    private List<Book> books;

    public Books() {
        this.books = new ArrayList<Book>();
    }

    public Books(List<Book> books) {
        this.books = books;
    }

    @XmlElement(name = "Book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if(this.books == null) {
            this.books = new ArrayList<Book>();
        }
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }

    public Integer getCount() {
        return this.books.size();
    }
}
