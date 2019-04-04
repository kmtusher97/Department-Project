package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CourseDescription")
public class CourseDescription {

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String Description;

    public String get_Title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_Description() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "CourseDescription{" +
                "title='" + title + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
