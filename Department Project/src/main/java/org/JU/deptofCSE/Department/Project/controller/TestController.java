package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.routine.Admin;
import org.JU.deptofCSE.Department.Project.model.routine.Calendar;
import org.JU.deptofCSE.Department.Project.model.routine.ExamCommittee;
import org.JU.deptofCSE.Department.Project.model.routine.Teacher;
import org.JU.deptofCSE.Department.Project.service.routine.AdminServices;
import org.JU.deptofCSE.Department.Project.service.routine.CalendarServices;
import org.JU.deptofCSE.Department.Project.service.routine.ExamCommitteeServices;
import org.JU.deptofCSE.Department.Project.service.routine.TeacherServices;
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

    @Autowired
    AdminServices adminServices;

    @Autowired
    CalendarServices calendarServices;

    @Autowired
    ExamCommitteeServices examCommitteeServices;
    

    @RequestMapping(value = "/allT", method = RequestMethod.GET)
    public List<Teacher> getAllTeacher() {
        return (List<Teacher>)teacherServices.getAllTeacher();
    }

    @RequestMapping(value = "/allA", method = RequestMethod.GET)
    public List<Admin> getAllAdmin() {
        return adminServices.getAllAdmin();
    }

    @RequestMapping(value = "/allC", method = RequestMethod.GET)
    public List<Calendar> getAllCalendar(){
        return calendarServices.getAllCalendar();
    }

    @RequestMapping(value = "/allE",method = RequestMethod.GET)
    public List<ExamCommittee> getAllExamcommittee() {
        return examCommitteeServices.getAllExamCommittee();
    }


}
