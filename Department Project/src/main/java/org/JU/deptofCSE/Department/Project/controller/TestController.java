package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.*;
import org.JU.deptofCSE.Department.Project.service.*;
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

    @Autowired
    VenueServices venueServices;

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
