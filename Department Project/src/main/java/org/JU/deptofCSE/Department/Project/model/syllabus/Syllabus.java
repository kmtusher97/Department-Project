package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Syllabus")
public class Syllabus {

    @XmlElement(name = "EffictiveFrom")
    private Integer effictiveFrom;

    @XmlElement(name = "EffictiveTo")
    private Integer effictiveTo;

    @XmlElement(name = "Semesters")
    private Semesters semesters;

    public Integer getEffictiveFrom() {
        return effictiveFrom;
    }

    public void setEffictiveFrom(Integer effictiveFrom) {
        this.effictiveFrom = effictiveFrom;
    }

    public Integer getEffictiveTo() {
        return effictiveTo;
    }

    public void setEffictiveTo(Integer effictiveTo) {
        this.effictiveTo = effictiveTo;
    }

    public Semesters getSemesters() {
        return semesters;
    }

    public void setSemesters(Semesters semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "Syllabus{" +
                "effictiveFrom=" + effictiveFrom +
                ", effictiveTo=" + effictiveTo +
                ", semesters=" + semesters +
                '}';
    }
}
