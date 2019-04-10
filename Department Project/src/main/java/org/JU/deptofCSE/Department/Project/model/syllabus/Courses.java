package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "Courses")
public class Courses {

    private SortedSet<Course> courses;

    public Courses() {
        this.courses = new TreeSet<Course>(
                Comparator.comparing(Course::getCourseCodeNumber)
        );
    }

    public Courses(TreeSet<Course> courses) {
        this.courses = courses;
    }

    @XmlElement(name = "Course")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(TreeSet<Course> courses) {
        this.courses = courses;
    }


    public void addCourse(Course course) {
        Course courseDelete = new Course();
        for(Course course1 : this.courses) {
            if(!course1.getCourseCode().equals(course.getCourseCode())) {
                continue;
            }
            courseDelete = course1;
            break;
        }
        this.courses.remove(courseDelete);
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courses=" + courses +
                '}';
    }
}
