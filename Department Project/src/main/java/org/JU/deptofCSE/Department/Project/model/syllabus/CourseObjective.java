package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CourseObjective")
public class CourseObjective {

    private String objective;

    public CourseObjective() {
    }

    public CourseObjective(String objective) {
        this.objective = objective;
    }

    @XmlElement(name = "Objective")
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    @Override
    public String toString() {
        return "CourseObjective{" +
                "objective='" + objective + '\'' +
                '}';
    }
}
