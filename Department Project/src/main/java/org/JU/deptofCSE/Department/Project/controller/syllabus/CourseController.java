package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/syl")
public class CourseController {

    @RequestMapping(value = "/addNewCourse")
    public ModelAndView getCourseData() {
        ModelAndView courseInputPage = new ModelAndView("AddNewCourse.html");

        return courseInputPage;
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public ModelAndView saveCourse() {
        return null;
    }
}
