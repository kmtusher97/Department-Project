package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Venue;

import java.util.List;

public interface VenueServices {

    public List<Venue> getAllVenue();
    public Venue getVenueById(Integer id);
    public void saveOrUpdate(Venue venue);
    public void delete(Integer id);
}
