package org.JU.deptofCSE.Department.Project.controller.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Teacher;
import org.JU.deptofCSE.Department.Project.model.routine.User;
import org.JU.deptofCSE.Department.Project.service.routine.TeacherServices;
import org.JU.deptofCSE.Department.Project.service.routine.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired
    TeacherServices teacherServices;

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
        if( userServices.isAdmin(requestedUser.getId()) ) {
            return new ModelAndView("redirect:/admin/dashboard");
        }
        else {
            return new ModelAndView("redirect:/teacher/dashboard");
        }
    }


    /**
     * If the requested email already exists then resend admin to the beginning
     * Saves the newly add user to database
     * Also creates an object of Teacher Class and stores it to database
     * @param newUser html form input
     * @return Add User page
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("userForm") User newUser) {
        if(userServices.getByEmail(newUser.getEmail()) != null) {
            return new ModelAndView("redirect:/admin/addUser/" + "error");
        }
        userServices.saveOrUpdateUser(newUser);

        Teacher newTeacher = new Teacher(userServices.getByEmail(newUser.getEmail()));
        teacherServices.saveOrUpdate(newTeacher);

        return new ModelAndView("redirect:/admin/addUser");
    }


    /**
     * Deletes an user from database
     * @param id path variable primary key
     * @return Add User page
     */
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") Integer id) {
        userServices.deleteUser(id);

        return new ModelAndView("redirect:/admin/addUser");
    }

    @RequestMapping(value = "/recoverPass", method = RequestMethod.GET)
    public ModelAndView recoverUserPassword() {
        ModelAndView passwordRecover = new ModelAndView("routine/PasswordRecoverPage");
        return passwordRecover;
    }
}
