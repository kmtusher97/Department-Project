package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Calendar;
import org.JU.deptofCSE.Department.Project.repository.routine.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class CalendarServicesImplementation implements CalendarServices {

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public List<Calendar> getAllCalendar() {
        return (List<Calendar>) calendarRepository.findAll();
    }

    @Override
    public Calendar getCalendarByDate(LocalDate date) {
        return calendarRepository.getOne(date);
    }

    @Override
    public void saveOrUpdate(Calendar calendar) {
        calendarRepository.save(calendar);
    }

    @Override
    public void delete(LocalDate date) {
        calendarRepository.deleteById(date);
    }

    @Override
    public List<LocalDate> generateDatesBetween(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }


}
