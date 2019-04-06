package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CourseDescriptions")
public class CourseDescriptions {

    private List<CourseDescription> courseDescription;

    public CourseDescriptions() {
    }

    public CourseDescriptions(List<CourseDescription> courseDescription) {
        this.courseDescription = courseDescription;
    }

    @XmlElement(name = "CourseDescription")
    public List<CourseDescription> getCourseDescription() { // set different name than variable name
        return courseDescription;
    }

    public void setCourseDescription(List<CourseDescription> courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void addCourseDescription(CourseDescription courseDescription) {
        if(this.courseDescription == null) {
            this.courseDescription = new ArrayList<CourseDescription>();
        }
        this.courseDescription.add(courseDescription);
    }

    @Override
    public String toString() {
        return "CourseDescriptions{" +
                "courseDescription=" + courseDescription +
                '}';
    }
}
