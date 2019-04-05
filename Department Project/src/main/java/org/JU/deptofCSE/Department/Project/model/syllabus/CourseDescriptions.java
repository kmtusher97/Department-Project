package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CourseDescriptions")
public class CourseDescriptions {

    private List<CourseDescription> courseDescriptions;

    @XmlElement(name = "CourseDescription")
    public List<CourseDescription> getCourseDescriptions() { // set different name than variable name
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
