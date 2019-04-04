package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CourseObjectives")
public class CourseObjectives {

    @XmlElement(name = "CourseObjective")
    List<String>courseObjective;

    public List<String> get_CourseObjective() {
        return courseObjective;
    }

    public void setCourseObjective(List<String> courseObjective) {
        this.courseObjective = courseObjective;
    }

    @Override
    public String toString() {
        return "CourseObjectives{" +
                "courseObjective=" + courseObjective +
                '}';
    }
}
