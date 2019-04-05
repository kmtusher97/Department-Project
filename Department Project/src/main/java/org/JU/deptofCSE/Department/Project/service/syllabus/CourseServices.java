package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;
import org.JU.deptofCSE.Department.Project.model.syllabus.CourseObjective;
import org.JU.deptofCSE.Department.Project.model.syllabus.CourseObjectives;
import org.JU.deptofCSE.Department.Project.repository.syllabus.CourseRepository;

import javax.xml.bind.JAXBException;
import java.util.List;

public class CourseServices {

    CourseRepository courseRepository = new CourseRepository();

    public void saveCourse(Course course) throws JAXBException {
        courseRepository.addCourse(course);
    }

    public Course getCourse() throws JAXBException {
        return courseRepository.getCourse();
    }

    public Course populateCourse(Course course) {
        CourseObjectives courseObjectives = new CourseObjectives();
        for(int i = 0; i < 5; i++) {
            courseObjectives.addCourseObjective(new CourseObjective());
        }
        course.setCourseObjectives(courseObjectives);
        return course;
    }

    public Course removeNullValues(Course course) {
        List<CourseObjective> courseObjectiveList = course.getCourseObjectives().getCourseObjective();
        course.setCourseObjectives(new CourseObjectives());
        for(CourseObjective courseObjective : courseObjectiveList) {
            if(courseObjective.getObjective().length() == 0) {
                continue;
            }
            course.addNewCourseObjective(courseObjective);
        }
        return course;
    }
}
