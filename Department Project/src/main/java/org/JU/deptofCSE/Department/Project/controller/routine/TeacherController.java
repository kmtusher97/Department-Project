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
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherServices teacherServices;

    @Autowired
    UserServices userServices;

    @RequestMapping(value = "/login/{userEmail}", method = RequestMethod.GET)
    public ModelAndView teacherLoginRequest(@PathVariable("userEmail") String userEmail) {
        User user = userServices.getByEmail(userEmail);
        Teacher teacher = teacherServices.getTeacherById(user.getId());

        ModelAndView teacherDashboard = new ModelAndView("routine/TeacherDashboard");
        teacherDashboard.addObject(user);
        teacherDashboard.addObject(teacher);

        return teacherDashboard;
    }
}
