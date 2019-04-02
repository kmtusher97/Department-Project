package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.VenueAvailability;

import java.util.Date;
import java.util.List;

public interface VenuAvailabilityServices {

    public List<VenueAvailability> getAllVenueAvailability();
    public VenueAvailability getVenueAvailabilityByDate(Date date);
    public void saveOrUpdate(VenueAvailability venueAvailability);
    public void delete(Date date);
}
