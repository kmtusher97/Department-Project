package org.JU.deptofCSE.Department.Project.controller;

import org.JU.deptofCSE.Department.Project.model.*;
import org.JU.deptofCSE.Department.Project.service.*;
import org.JU.deptofCSE.Department.Project.service.routine.CalendarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    CalendarServices calendarServices;

    @RequestMapping(value = "/dates", method = RequestMethod.GET)
    public List<LocalDate> getDates() {
        LocalDate startDate = LocalDate.of(2019, Month.APRIL, 1);
        LocalDate endDate = LocalDate.of(2019, Month.MAY, 2);
        return calendarServices.generateDatesBetween(startDate, endDate);
    }

}
