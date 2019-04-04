package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CourseDescriptions")
public class CourseDescriptions {

    @XmlElement(name = "CourseDescription")
    private List<CourseDescription> courseDescriptions;

    public List<CourseDescription> get_CourseDescriptions() { // set different name than variable name
        return courseDescriptions;
    }

    public void setCourseDescriptions(List<CourseDescription> courseDescriptions) {
        this.courseDescriptions = courseDescriptions;
    }

    @Override
    public String toString() {
        return "CourseDescriptions{" +
                "courseDescriptions=" + courseDescriptions +
                '}';
    }
}
