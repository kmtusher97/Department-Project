package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.*;
import org.JU.deptofCSE.Department.Project.repository.syllabus.CourseRepository;
import org.JU.deptofCSE.Department.Project.repository.syllabus.SyllabusRepository;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CourseServices {

    CourseRepository courseRepository = new CourseRepository();

    SyllabusRepository syllabusRepository = new SyllabusRepository();

    /**
     * Get Course Object.
     * @return Course Object
     * @throws JAXBException
     */
    public Course getCourse() throws JAXBException {
        return courseRepository.getCourse();
    }

    /**
     * Initially fill the List fields with null objects.
     * @param course
     * @return populate object of the Course
     */
    public Course populateCourse(Course course) {
        for(int i = course.getCountOfBooks(); i < 6; i++) {
            course.addNewBook(new Book());
        }

        for(int i = course.getCountOfCourseObjectives(); i < 15; i++) {
            course.addNewCourseObjective(new CourseObjective());
        }

        for(int i = course.getCountOfLearningOutComes(); i < 15; i++) {
            course.addNewLearningOutcome(new LearningOutcome());
        }

        for(int i = course.getCountOfCourseDescriptions(); i < 15; i++) {
            course.addNewCourseDescription(new CourseDescription());
        }

        for(int i = course.getCountOfLaboratoryRequirements(); i < 15; i++) {
            course.addNewLaboratoryRequirement(new LaboratoryRequirement());
        }

        return course;
    }

    /**
     * Remove the null objects from the List fields.
     * @param course
     * @return null object free Course Object
     */
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
            if(courseDescription.getTitle().length() == 0 && courseDescription.getDescription().length() == 0) {
                continue;
            }
            course.addNewCourseDescription(courseDescription);
        }

        List<LaboratoryRequirement> laboratoryRequirementList = course.getLaboratoryRequirements().getLaboratoryRequirement();
        course.setLaboratoryRequirements(new LaboratoryRequirements());
        for(LaboratoryRequirement laboratoryRequirement : laboratoryRequirementList) {
            if(laboratoryRequirement.getTitle().length() == 0 && laboratoryRequirement.getRequirement().length() == 0) {
                continue;
            }
            course.addNewLaboratoryRequirement(laboratoryRequirement);
        }

        return course;
    }

    /**
     * Get Course By Semester Name And Course Code
     * @param semesterList
     * @param semesterName
     * @param courseCode
     * @return Requested Course
     */
    public Course getCoursesBySemesterNameAndCourseCode(TreeSet<Semester> semesterList, String semesterName, String courseCode) {
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

    /**
     * Delete the requested Course from syllabus
     * @param course
     * @param semesterName
     * @param fileName
     * @throws JAXBException
     */
    public void removeCourse(Course course, String semesterName, String fileName) throws JAXBException {
        Syllabus syllabus = syllabusRepository.getSyllabus(fileName);
        syllabus.removeCourse(course, semesterName);
        syllabusRepository.addSyllabus(syllabus, fileName);
    }
}
