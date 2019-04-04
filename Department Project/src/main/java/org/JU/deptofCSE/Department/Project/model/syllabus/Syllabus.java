package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Syllabus")
public class Syllabus {

    @XmlElement(name = "Semesters")
    List<Semesters> semesters;

    public List<Semesters> get_Semesters() {
        return semesters;
    }

    public void setSemesters(List<Semesters> semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "Syllabus{" +
                "semesters=" + semesters +
                '}';
    }
}
