package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Courses")
public class Courses {

    @XmlElement(name = "Course")
    List<Course>courses;

    public List<Course> get_Courses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courses=" + courses +
                '}';
    }
}
