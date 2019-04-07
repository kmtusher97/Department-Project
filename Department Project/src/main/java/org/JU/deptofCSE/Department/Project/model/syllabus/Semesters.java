package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Semesters")
public class Semesters {

    List<Semester>semesters;

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

    @Override
    public String toString() {
        return "Semesters{" +
                "semesters=" + semesters +
                '}';
    }
}
