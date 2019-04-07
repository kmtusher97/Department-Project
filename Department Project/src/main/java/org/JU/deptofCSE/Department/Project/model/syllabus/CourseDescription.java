package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CourseDescription")
public class CourseDescription {

    private String title;

    private String description;

    public CourseDescription() {
        this.title = "";
        this.description = "";
    }

    public CourseDescription(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseDescription{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
