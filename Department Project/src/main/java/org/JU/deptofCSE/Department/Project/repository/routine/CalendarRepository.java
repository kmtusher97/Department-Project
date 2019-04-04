package org.JU.deptofCSE.Department.Project.repository.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CalendarRepository extends JpaRepository<Calendar, Date> {
}
