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
import java.util.SortedSet;
import java.util.TreeSet;

@Controller
@RequestMapping(value = "/syl")
public class CourseController {

    CourseServices courseServices = new CourseServices();
    SyllabusServices syllabusServices = new SyllabusServices();

    @RequestMapping(value = "/addNewCourse/{semesterName}/{fileName}", method = RequestMethod.GET)   // request to add a new course, in requested semester of requested syllabus
    public ModelAndView addNewCourse(@PathVariable("semesterName") String semesterName,
                                     @PathVariable("fileName") String fileName) {
        Course course = new Course();
        course = courseServices.populateCourse(course);                                              // populate the List fields for user input

        ModelAndView courseEditPage = new ModelAndView("syllabus/AddNewCourse");           // then through user to course edit form
        courseEditPage.addObject("courseEditForm", course);
        courseEditPage.addObject("semesterName", semesterName);
        courseEditPage.addObject("fileName", fileName);
        String courseCodeDelete = "000";
        courseEditPage.addObject("courseCodeDelete", courseCodeDelete);
        return courseEditPage;
    }

    @RequestMapping(value = "/saveCourse/{semesterName}/{fileName}/{courseCodeDelete}", method = RequestMethod.POST)   // request to save the course after editing info
    public ModelAndView saveOrUpdateCourse(@ModelAttribute("courseEditForm") Course course,
                                           @PathVariable("semesterName") String semesterName,
                                           @PathVariable("fileName") String fileName,
                                           @PathVariable("courseCodeDelete") String courseCodeDelete) throws JAXBException {
        System.err.println(courseCodeDelete);
        if(!courseCodeDelete.equals("000")) {
            SortedSet<Semester> semesterList = syllabusServices.getSyllabus(fileName).getSemesters().getSemesters();     // get the semesters of the syllabus
            Course courseDelete = courseServices.getCoursesBySemesterNameAndCourseCode((TreeSet<Semester>) semesterList, semesterName, courseCodeDelete); // get the course from the semester list
            courseServices.removeCourse(courseDelete, semesterName, fileName);                           // delete the previous instance of the course
        }

        course = courseServices.removeNullValues(course);                                            // remove null values from the List fields
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                  // get the syllabus using file name
        syllabus.addNewCourse(course, semesterName);                                                 // add the course to the syllabus object
        syllabusServices.saveSyllabus(syllabus, fileName);                                           // save the changes to xml repository

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                     // return to the edit syllabus page
    }

    @RequestMapping(value = "/updateCourse/{courseCode}/{semesterName}/{fileName}", method = RequestMethod.GET)      // request to update a course
    public ModelAndView updateCourse(@PathVariable("courseCode") String courseCode,
                                     @PathVariable("semesterName") String semesterName,
                                     @PathVariable("fileName") String fileName) throws JAXBException {
        SortedSet<Semester> semesterList = syllabusServices.getSyllabus(fileName).getSemesters().getSemesters();     // get the semesters of the syllabus
        Course course = courseServices.getCoursesBySemesterNameAndCourseCode((TreeSet<Semester>) semesterList, semesterName, courseCode); // get the course from the semester list
        course = courseServices.populateCourse(course);

        ModelAndView courseEditPage = new ModelAndView("syllabus/AddNewCourse");
        courseEditPage.addObject("courseEditForm", course);
        courseEditPage.addObject("semesterName", semesterName);
        courseEditPage.addObject("fileName", fileName);
        courseEditPage.addObject("courseCodeDelete", course.getCourseCode());                                 // delete the current instance after hitting submit
        return courseEditPage;
    }

    @RequestMapping(value = "/deleteCourse/{courseCode}/{semesterName}/{fileName}", method = RequestMethod.GET) // request to delete a course
    public ModelAndView deleteCourse(@PathVariable("courseCode") String courseCode,
                                     @PathVariable("semesterName") String semesterName,
                                     @PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                             // get the syllabus
        SortedSet<Semester> semesterList = syllabus.getSemesters().getSemesters();
        Course course = courseServices.getCoursesBySemesterNameAndCourseCode((TreeSet<Semester>) semesterList, semesterName, courseCode); // get the course by course code
        syllabus.removeCourse(course, semesterName);                                                            // remove the course
        syllabusServices.saveSyllabus(syllabus, fileName);                                                      // store the changes to xml repository

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                                // return to the edit syllabus page
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView readCourse() throws JAXBException {
        ModelAndView modelAndView = new ModelAndView("syllabus/SyllabusView");
        Course course = courseServices.getCourse();
        System.err.println(course);
        return modelAndView;
    }

}
