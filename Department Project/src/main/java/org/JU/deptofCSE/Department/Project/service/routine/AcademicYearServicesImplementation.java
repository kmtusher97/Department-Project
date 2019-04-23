package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.AcademicYear;
import org.JU.deptofCSE.Department.Project.model.routine.Calendar;
import org.JU.deptofCSE.Department.Project.repository.routine.AcademicYearRepository;
import org.JU.deptofCSE.Department.Project.repository.routine.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class AcademicYearServicesImplementation implements AcademicYearServices {

    @Autowired
    AcademicYearRepository academicYearRepository;

    @Autowired
    CalendarServices calendarServices;

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public List<AcademicYear> getAllAcademicYears() {
        return academicYearRepository.findAll();
    }

    @Override
    public AcademicYear getAcademicYear(Integer year) {
        return academicYearRepository.getOne(year);
    }

    /**
     * Save the year and store all the dates of the year in calendar table
     *
     * @param academicYear
     */
    @Override
    public void saveAcademicYear(AcademicYear academicYear) {
        academicYearRepository.save(academicYear);
        List<LocalDate> dateList = calendarServices.generateDatesBetween(academicYear.getFirstDate(), academicYear.getLastDate());
        System.out.println(dateList);
        for (LocalDate date : dateList) {
            calendarRepository.save(new Calendar(date));
        }
    }

    @Override
    public void deleteAcademicYear(Integer year) {
        academicYearRepository.deleteById(year);
    }
}
