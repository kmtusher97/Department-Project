package org.JU.deptofCSE.Department.Project.repository.routine;

import org.JU.deptofCSE.Department.Project.model.routine.TeacherAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TeacherAvailabilityRepository extends JpaRepository<TeacherAvailability, Date> {
}
