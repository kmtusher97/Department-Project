package org.JU.deptofCSE.Department.Project.repository;

import org.JU.deptofCSE.Department.Project.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CalendarRepository extends JpaRepository<Calendar, Date> {
}
