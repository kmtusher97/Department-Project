package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "authors")
public class Authors {

    @XmlElement(name = "author")
    List<String> author;

    public List<String> getAuthors() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "author=" + author +
                '}';
    }
}
