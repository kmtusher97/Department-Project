package org.JU.deptofCSE.Department.Project.controller.routine;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView teacherDashboard() {
        ModelAndView teacherDashboard = new ModelAndView("routine/TeacherHomePage");
        return teacherDashboard;
    }
}
