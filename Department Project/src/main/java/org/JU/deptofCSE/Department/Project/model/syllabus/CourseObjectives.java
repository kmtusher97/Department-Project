package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CourseObjectives")
public class CourseObjectives {

    private List<CourseObjective> courseObjective;

    public CourseObjectives() {
    }

    public CourseObjectives(List<CourseObjective> courseObjective) {
        this.courseObjective = courseObjective;
    }

    @XmlElement(name = "CourseObjective")
    public List<CourseObjective> getCourseObjective() {
        return courseObjective;
    }

    public void setCourseObjective(List<CourseObjective> courseObjective) {
        this.courseObjective = courseObjective;
    }

    public void addCourseObjective(CourseObjective courseObjective) {
        if( this.courseObjective == null ) {
            this.courseObjective = new ArrayList<CourseObjective>();
        }
        this.courseObjective.add(courseObjective);
    }

    @Override
    public String toString() {
        return "CourseObjectives{" +
                "courseObjective=" + courseObjective +
                '}';
    }
}
