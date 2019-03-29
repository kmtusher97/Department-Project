package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

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
        System.err.println(user);
        return null;
    }
}
