package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "Semesters")
public class Semesters {

    private SortedSet<Semester> semesters;

    public Semesters() {
        this.semesters = new TreeSet<Semester>(
                Comparator.comparing(Semester::getSemesterId)
        );
    }

    public Semesters(TreeSet<Semester> semesters) {
        this.semesters = semesters;
    }

    @XmlElement(name = "Semester")
    public SortedSet<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(TreeSet<Semester> semesters) {
        this.semesters = semesters;
    }

    public void addSemseter(Semester semester) {
        if(this.semesters == null) {
            this.semesters = new TreeSet<Semester>();
        }
        this.semesters.add(semester);
    }


    public void addSemester(Semester semester) {
        if(this.semesters == null) {
            this.semesters = new TreeSet<Semester>();
        }
        this.semesters.add(semester);
    }

    public void addCourse(Course course, String semesterName) {
        for(Semester semester : this.semesters) {
            if(semester.getName().equals(semesterName)) {
                semester.addCourse(course);
            }
        }
    }

    public Integer getFirstMissingSemesterId() {
        Integer last = 0;
        for(Semester semester : semesters) {
            Integer current = semester.getSemesterId();
            if(current - last > 1) {
                return last + 1;
            }
            else {
                last = current;
            }
        }
        return last + 1;
    }

    @Override
    public String toString() {
        return "Semesters{" +
                "semesters=" + semesters +
                '}';
    }
}
