package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;

import org.JU.deptofCSE.Department.Project.model.syllabus.Semester;
import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.service.syllabus.CourseServices;
import org.JU.deptofCSE.Department.Project.service.syllabus.SyllabusServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.util.List;

@Controller
@RequestMapping(value = "/syl")
public class CourseController {

    CourseServices courseServices = new CourseServices();
    SyllabusServices syllabusServices = new SyllabusServices();

    @RequestMapping(value = "/addNewCourse/{semesterName}/{fileName}", method = RequestMethod.GET)
    public ModelAndView addNewCourse(@PathVariable("semesterName") String semesterName,
                                               @PathVariable("fileName") String fileName) {
        Course course = new Course();
        ModelAndView courseEditPage = new ModelAndView("syllabus/AddNewCourse");
        course = courseServices.populateCourse(course);

        courseEditPage.addObject("courseEditForm", course);
        courseEditPage.addObject("semesterName", semesterName);
        courseEditPage.addObject("fileName", fileName);
        return courseEditPage;
    }

    @RequestMapping(value = "/saveCourse/{semesterName}/{fileName}", method = RequestMethod.POST)
    public ModelAndView saveCourse(@ModelAttribute("courseEditForm") Course course,
                                   @PathVariable("semesterName") String semesterName,
                                   @PathVariable("fileName") String fileName) throws JAXBException {
        course = courseServices.removeNullValues(course);
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);
        syllabus.addNewCourse(course, semesterName);
        syllabusServices.saveSyllabus(syllabus, fileName);

        ModelAndView editSyllabusPage = new ModelAndView("syllabus/EditSyllabus");
        editSyllabusPage.addObject("syllabus", syllabus);
        editSyllabusPage.addObject("fileName", fileName);

        return editSyllabusPage;
    }

    @RequestMapping(value = "/updateCourse/{courseCode}/{semesterName}/{fileName}", method = RequestMethod.GET)
    public ModelAndView updateCourse(@PathVariable("courseCode") String courseCode,
                                     @PathVariable("semesterName") String semesterName,
                                     @PathVariable("fileName") String fileName) throws JAXBException {
        System.err.println(courseCode + " " + semesterName + " " + fileName);
        List<Semester> semesterList = syllabusServices.getSyllabus(fileName).getSemesters().getSemesters();
        Course course = courseServices.getCoursesBySemesterNameAndCourseCode(semesterList, semesterName, courseCode);
        course = courseServices.populateCourse(course);

        ModelAndView courseEditPage = new ModelAndView("syllabus/AddNewCourse");
        courseEditPage.addObject("courseEditForm", course);
        courseEditPage.addObject("semesterName", semesterName);
        courseEditPage.addObject("fileName", fileName);
        return courseEditPage;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView readCourse() throws JAXBException {
        ModelAndView modelAndView = new ModelAndView("syllabus/SyllabusView");
        Course course = courseServices.getCourse();
        System.err.println(course);
        return modelAndView;
    }

}
