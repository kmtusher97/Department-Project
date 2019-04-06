package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;
import org.JU.deptofCSE.Department.Project.model.syllabus.CourseObjective;
import org.JU.deptofCSE.Department.Project.model.syllabus.CourseObjectives;
import org.JU.deptofCSE.Department.Project.model.syllabus.LearningOutcomes;
import org.JU.deptofCSE.Department.Project.service.syllabus.CourseServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/syl")
public class CourseController {

    CourseServices courseServices = new CourseServices();

    @RequestMapping(value = "/addNewCourse", method = RequestMethod.GET)
    public ModelAndView getCourseData() {
        ModelAndView courseInputPage = new ModelAndView("AddNewCourse");
        Course courseEditForm = courseServices.populateCourse(new Course());
        courseInputPage.addObject("courseEditForm", courseEditForm);
        return courseInputPage;
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public ModelAndView saveCourse(@ModelAttribute("courseEditForm") Course course) throws JAXBException {
        ModelAndView modelAndView = new ModelAndView("SavedCourse");
        //System.err.println(course);
        course = courseServices.removeNullValues(course);
        courseServices.saveCourse(course);
        System.err.println(course);
        modelAndView.addObject(course);
        return modelAndView;
    }

}
