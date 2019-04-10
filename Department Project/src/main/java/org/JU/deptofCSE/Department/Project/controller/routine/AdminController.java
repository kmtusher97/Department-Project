package org.JU.deptofCSE.Department.Project.controller.routine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView adminDashboard() {
        ModelAndView adminDashboard = new ModelAndView("routine/AdminDashboard");
        return adminDashboard;
    }
}
