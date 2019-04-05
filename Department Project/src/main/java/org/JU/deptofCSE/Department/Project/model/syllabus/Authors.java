package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Authors")
public class Authors {

    List<String> author;

    @XmlElement(name = "Author")
    public List<String> getAuthor() {
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
