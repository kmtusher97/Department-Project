package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Calendar;
import org.JU.deptofCSE.Department.Project.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CalendarServicesImplementation implements CalendarServices {

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public List<Calendar> getAllCalendar() {
        return (List<Calendar>)calendarRepository.findAll();
    }

    @Override
    public Calendar getCalendarByDate(Date date) { return calendarRepository.getOne(date); }

    @Override
    public void saveOrUpdate(Calendar calendar) { calendarRepository.save(calendar); }

    @Override
    public void delate(Date date) { calendarRepository.deleteById(date); }

}
