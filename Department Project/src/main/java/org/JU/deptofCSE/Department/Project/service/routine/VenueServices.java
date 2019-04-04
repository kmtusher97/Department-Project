package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Venue;

import java.util.List;

public interface VenueServices {

    public List<Venue> getAllVenue();
    public Venue getVenueById(Integer id);
    public void saveOrUpdate(Venue venue);
    public void delete(Integer id);
}
