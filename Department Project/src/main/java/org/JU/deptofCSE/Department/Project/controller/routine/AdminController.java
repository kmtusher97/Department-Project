package org.JU.deptofCSE.Department.Project.controller.routine;

import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/addSyll", method = RequestMethod.GET)
    public ModelAndView addNewSyllabus() {
        return new ModelAndView("redirect:/syl/addNewSyll");
    }

    @RequestMapping(value = "/editSyll", method = RequestMethod.POST)
    public ModelAndView editSyllabus(@ModelAttribute("syllabusForm")Syllabus syllabusForm) {
        String fileName = syllabusForm.makeXmlFileName();
        return new ModelAndView("redirect:/syl/editSyll/" +fileName);
    }
}
