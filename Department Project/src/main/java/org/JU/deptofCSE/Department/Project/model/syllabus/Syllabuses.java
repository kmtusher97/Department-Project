package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Syllabuses")
public class Syllabuses {

    @XmlElement(name = "Syllabus")
    List<Semesters>syllabus;

    public List<Semesters> get_Syllabus() {
        return syllabus;
    }

    public void setSyllabus(List<Semesters> syllabus) {
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return "Syllabuses{" +
                "syllabus=" + syllabus +
                '}';
    }
}
