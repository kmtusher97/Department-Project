package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "syllabus")
public class Syllabus {

    private Integer effictiveFrom;

    private Integer effictiveTo;

    private Semesters semesters;


    @XmlElement(name = "EffictiveFrom")
    public Integer getEffictiveFrom() {
        return effictiveFrom;
    }

    public void setEffictiveFrom(Integer effictiveFrom) {
        this.effictiveFrom = effictiveFrom;
    }

    @XmlElement(name = "EffictiveTo")
    public Integer getEffictiveTo() {
        return effictiveTo;
    }

    public void setEffictiveTo(Integer effictiveTo) {
        this.effictiveTo = effictiveTo;
    }

    @XmlElement(name = "Semesters")
    public Semesters getSemesters() {
        return semesters;
    }

    public void setSemesters(Semesters semesters) {
        this.semesters = semesters;
    }



    public Integer countOfSemesters() {
        return semesters.getSemesters().size();
    }

    public void populateSemestes(int numberOfSemesters) {
        for(int i = countOfSemesters(); i < numberOfSemesters; i++) {
            this.semesters.addSemseter(new Semester());
        }
    }

    @Override
    public String toString() {
        return "syllabus{" +
                "effictiveFrom=" + effictiveFrom +
                ", effictiveTo=" + effictiveTo +
                ", semesters=" + semesters +
                '}';
    }
}
