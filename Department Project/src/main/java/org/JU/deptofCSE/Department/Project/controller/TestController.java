package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.Teacher;
import org.JU.deptofCSE.Department.Project.model.User;
import org.JU.deptofCSE.Department.Project.service.TeacherServices;
import org.JU.deptofCSE.Department.Project.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TeacherServices teacherServices;

    @RequestMapping(value = "/allT", method = RequestMethod.GET)
    public List<Teacher> getAllTeacher() {
        return (List<Teacher>)teacherServices.getAllTeacher();
    }
}
