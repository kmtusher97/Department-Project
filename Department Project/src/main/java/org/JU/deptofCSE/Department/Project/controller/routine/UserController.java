package org.JU.deptofCSE.Department.Project.controller.routine;

import org.JU.deptofCSE.Department.Project.model.routine.User;
import org.JU.deptofCSE.Department.Project.service.routine.UserServices;
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
        ModelAndView loginPage = new ModelAndView("routine/UserLoginPage");
        User userForm = new User();
        userForm.setId(0);
        loginPage.addObject("userForm", userForm);
        return loginPage;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView authenticateLogin(@ModelAttribute("userForm") User user) {
        User requestedUser = userServices.getByEmail(user.getEmail());

        if(requestedUser == null || !requestedUser.getPassword().equals(user.getPassword())) {
            return new ModelAndView("redirect:/login");
        }
        ModelAndView homePage;
        if( userServices.isAdmin(requestedUser.getId()) ) {
            homePage = new ModelAndView("routine/AdminHomePage");
        }
        else {
            homePage = new ModelAndView("routine/TeacherHomePage");
        }
        return homePage;
    }

    @RequestMapping(value = "/recoverPass", method = RequestMethod.GET)
    public ModelAndView recoverUserPassword() {
        ModelAndView passwordRecover = new ModelAndView("routine/PasswordRecoverPage");
        return passwordRecover;
    }
}
