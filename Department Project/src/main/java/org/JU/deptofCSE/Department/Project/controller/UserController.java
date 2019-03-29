package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.User;
import org.JU.deptofCSE.Department.Project.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView userLogin() {
        ModelAndView loginPage = new ModelAndView("UserLoginPage");
        User userForm = new User();
        userForm.setId(0);
        loginPage.addObject("userForm", userForm);
        return loginPage;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView authenticateLogin(@ModelAttribute("userForm") User user) {
        User requestedUser = userServices.getByEmail(user.getEmail());
        if(requestedUser == null) {
            return new ModelAndView("redirect/login");
        }
        ModelAndView homePage;
        if( requestedUser.getId() == 1001 ) {
            homePage = new ModelAndView("AdminHomePage");
        }
        else {
            homePage = new ModelAndView("TeacherHomePage");
        }
        return homePage;
    }
}
