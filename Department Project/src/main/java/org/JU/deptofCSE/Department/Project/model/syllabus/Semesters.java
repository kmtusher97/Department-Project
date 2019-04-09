package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Semesters")
public class Semesters {

    private List<Semester> semesters;

    public Semesters() {
        this.semesters = new ArrayList<Semester>();
    }

    public Semesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    @XmlElement(name = "Semester")
    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public void addSemseter(Semester semester) {
        if(this.semesters == null) {
            this.semesters = new ArrayList<Semester>();
        }
        this.semesters.add(semester);
    }


    public void addSemester(Semester semester) {
        if(this.semesters == null) {
            this.semesters = new ArrayList<Semester>();
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

    @Override
    public String toString() {
        return "Semesters{" +
                "semesters=" + semesters +
                '}';
    }
}
