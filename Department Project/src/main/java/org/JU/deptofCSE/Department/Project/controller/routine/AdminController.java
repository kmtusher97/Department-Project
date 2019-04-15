package org.JU.deptofCSE.Department.Project.controller.routine;

import org.JU.deptofCSE.Department.Project.model.routine.User;
import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.service.routine.AdminServices;
import org.JU.deptofCSE.Department.Project.service.routine.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserServices userServices;

    @Autowired
    AdminServices adminServices;

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


    /**
     * Admin request to add new user
     * This page also view all the users emails are currently in the system
     * @return AddUser page
     */
    @RequestMapping(value = "/addUser/{error}", method = RequestMethod.GET)
    public ModelAndView addNewUser() {
        User user = new User();
        List<User> userList = userServices.getAllUser();

        ModelAndView addUserPage = new ModelAndView("routine/AddUser");
        addUserPage.addObject("userForm", user);
        addUserPage.addObject("userList", userList);
        return addUserPage;
    }
}
