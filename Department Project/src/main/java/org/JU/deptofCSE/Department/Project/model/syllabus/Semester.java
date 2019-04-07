package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Semester")
public class Semester {

    private String name;

    private Courses courses;

    public Semester() {
        this.name = "";
        this.courses = new Courses();
    }

    public Semester(String name, Courses courses) {
        this.name = name;
        this.courses = courses;
    }

    @XmlElement(name = "SemesterName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Courses")
    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }


    public void addCourse(Course course) {
        this.courses.addCourse(course);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
