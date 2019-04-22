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
        teacherDashboard.addObject("user", user);
        teacherDashboard.addObject("teacher", teacher);

        return teacherDashboard;
    }


    /**
     * Provides a profile edit form to update teacher profile information
     *
     * @param teacherId
     * @return Send edited data to store in database
     */
    @RequestMapping(value = "/updateInfo/{teacherId}", method = RequestMethod.GET)
    public ModelAndView updateTeacherProfile(@PathVariable("teacherId") Integer teacherId) {
        Teacher teacher = teacherServices.getTeacherById(teacherId);

        System.err.println("Before " + teacher);

        ModelAndView teacherProfileEditForm = new ModelAndView("routine/UpdateTeacherInfo");
        teacherProfileEditForm.addObject("user", userServices.getUserByID(teacherId));
        teacherProfileEditForm.addObject("teacher", teacher);

        return teacherProfileEditForm;
    }

    /**
     * Save updated info of teacher profile to database
     *
     * @param teacherId
     * @param teacherEdited
     * @return redirects to Teacher Dashboard Pager
     */
    @RequestMapping(value = "/saveTeacherInfo/{teacherId}", method = RequestMethod.POST)
    public ModelAndView saveTeacherProfile(@PathVariable("teacherId") Integer teacherId,
                                           @ModelAttribute("teacher") Teacher teacherEdited) {
        Teacher teacher = teacherServices.getTeacherById(teacherId);
        teacher = teacherServices.updateTeacherWithEditedData(teacher, teacherEdited);
        System.err.println(teacher);
        teacherServices.saveOrUpdate(teacher);

        return new ModelAndView("redirect:/teacher/login/" + userServices.getUserByID(teacherId).getEmail());
    }
}
