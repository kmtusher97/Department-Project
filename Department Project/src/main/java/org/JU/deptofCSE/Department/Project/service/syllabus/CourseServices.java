package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.*;
import org.JU.deptofCSE.Department.Project.repository.syllabus.CourseRepository;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Set;

public class CourseServices {

    CourseRepository courseRepository = new CourseRepository();

    public void saveCourse(Course course) throws JAXBException {
        courseRepository.addCourse(course);
    }

    public Course getCourse() throws JAXBException {
        return courseRepository.getCourse();
    }

    public Course populateCourse(Course course) {
        for(int i = course.getCountOfBooks(); i < 5; i++) {
            course.addNewBook(new Book());
        }

        for(int i = course.getCountOfCourseObjectives(); i < 10; i++) {
            course.addNewCourseObjective(new CourseObjective());
        }

        for(int i = course.getCountOfLearningOutComes(); i < 10; i++) {
            course.addNewLearningOutcome(new LearningOutcome());
        }

        for(int i = course.getCountOfCourseDescriptions(); i < 10; i++) {
            course.addNewCourseDescription(new CourseDescription());
        }
        return course;
    }

    public Course removeNullValues(Course course) {
        List<Book> bookList = course.getBooks().getBooks();
        course.setBooks(new Books());
        for(Book book : bookList) {
            if(book.getBookName().length() == 0) {
                continue;
            }
            course.addNewBook(book);
        }

        List<CourseObjective> courseObjectiveList = course.getCourseObjectives().getCourseObjective();
        course.setCourseObjectives(new CourseObjectives());
        for(CourseObjective courseObjective : courseObjectiveList) {
            if(courseObjective.getObjective().length() == 0) {        // remove the null entries
                continue;
            }
            course.addNewCourseObjective(courseObjective);
        }

        List<LearningOutcome> learningOutcomeList = course.getLearningOutcomes().getLearningOutcome();
        course.setLearningOutcomes(new LearningOutcomes());
        for(LearningOutcome learningOutcome : learningOutcomeList) {
            if(learningOutcome.getOutcome().length() == 0) {          // remove the null entries
                continue;
            }
            course.addNewLearningOutcome(learningOutcome);
        }

        List<CourseDescription> courseDescriptionList = course.getCourseDescriptions().getCourseDescription();
        course.setCourseDescriptions(new CourseDescriptions());
        for(CourseDescription courseDescription : courseDescriptionList) {
            if(courseDescription.getTitle().length() == 0 || courseDescription.getDescription().length() == 0) {
                continue;
            }
            course.addNewCourseDescription(courseDescription);
        }
        return course;
    }

    public Course getCoursesBySemesterNameAndCourseCode(List<Semester> semesterList, String semesterName, String courseCode) {
        for(Semester semester : semesterList) {
            if(!semester.getName().equals(semesterName)) {
                continue;
            }
            Set<Course> courseList = semester.getCourses().getCourses();
            for(Course course : courseList) {
                if(!course.getCourseCode().equals(courseCode)) {
                    continue;
                }
                return course;
            }
        }
        return null;
    }
}
