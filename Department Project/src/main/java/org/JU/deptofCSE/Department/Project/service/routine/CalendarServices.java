package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Calendar;

import java.util.Date;
import java.util.List;

public interface CalendarServices {

    public List<Calendar> getAllCalendar();
    public Calendar getCalendarByDate(Date date);
    public  void  saveOrUpdate(Calendar calendar);
    public  void  delate(Date date);
}
