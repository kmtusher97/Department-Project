package org.JU.deptofCSE.Department.Project.repository.routine;

import org.JU.deptofCSE.Department.Project.model.routine.VenueAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability, Date> {
}
