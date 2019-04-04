package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;
import org.JU.deptofCSE.Department.Project.repository.syllabus.CourseRepository;

import javax.xml.bind.JAXBException;

public class CourseServices {

    CourseRepository courseRepository = new CourseRepository();

    public void saveCourse(Course course) throws JAXBException {
        courseRepository.addCourse(course);
    }

    public Course getCourse() throws JAXBException {
        return courseRepository.getCourse();
    }
}
