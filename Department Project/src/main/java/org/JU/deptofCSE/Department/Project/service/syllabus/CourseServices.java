package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.*;
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
        Books books = new Books();
        CourseObjectives courseObjectives = new CourseObjectives();
        LearningOutcomes learningOutcomes = new LearningOutcomes();
        CourseDescriptions courseDescriptions = new CourseDescriptions();

        for(int i = 0; i < 5; i++) {
            books.addBook(new Book());
            courseObjectives.addCourseObjective(new CourseObjective());
            learningOutcomes.addLearningOutcome(new LearningOutcome());
        }

        for(int i = 0; i < 8; i++) {
            courseDescriptions.addCourseDescription(new CourseDescription());
        }

        course.setBooks(books);
        course.setCourseObjectives(courseObjectives);
        course.setLearningOutcomes(learningOutcomes);
        course.setCourseDescriptions(courseDescriptions);
        return course;
    }

    public Course removeNullValues(Course course) {
        List<Book> bookList = course.getBooks().getBooks();
        course.setBooks(new Books());
        for(Book book : bookList) {
            if(book.getBookName().length() == 0 || book.getAuthorsString().length() == 0) {
                continue;
            }
            book.makeAuthorList();
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
}
