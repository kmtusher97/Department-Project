package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Calendar;

import java.time.LocalDate;
import java.util.List;

public interface CalendarServices {

    public List<Calendar> getAllCalendar();

    public Calendar getCalendarByDate(LocalDate date);

    public void saveOrUpdate(Calendar calendar);

    public void delete(LocalDate date);

    public List<LocalDate> generateDatesBetween(LocalDate startDate, LocalDate endDate);
}
