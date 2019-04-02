package org.JU.deptofCSE.Department.Project.repository;

import org.JU.deptofCSE.Department.Project.model.TeacherAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TeacherAvailabilityRepository extends JpaRepository<TeacherAvailability, Date> {
}
