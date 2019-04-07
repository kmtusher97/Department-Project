package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.VenueAvailability;

import java.util.Date;
import java.util.List;

public interface VenuAvailabilityServices {

    public List<VenueAvailability> getAllVenueAvailability();
    public VenueAvailability getVenueAvailabilityByDate(Date date);
    public void saveOrUpdate(VenueAvailability venueAvailability);
    public void delete(Date date);
}
