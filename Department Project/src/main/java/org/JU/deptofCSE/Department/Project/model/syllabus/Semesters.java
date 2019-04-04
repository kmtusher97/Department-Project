package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Semesters")
public class Semesters {

    @XmlElement(name = "Semester")
    List<Semester>semesters;

    public List<Semester> get_Semesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "Semesters{" +
                "semesters=" + semesters +
                '}';
    }
}
