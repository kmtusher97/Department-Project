package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Semester")
public class Semester {

    @XmlElement(name = "Courses")
    private Courses courses;

    public Courses get_Courses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "courses=" + courses +
                '}';
    }
}
