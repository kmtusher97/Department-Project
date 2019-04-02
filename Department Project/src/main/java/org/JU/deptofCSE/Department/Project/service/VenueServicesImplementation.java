package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Venue;
import org.JU.deptofCSE.Department.Project.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VenueServicesImplementation implements VenueServices {

    @Autowired
    VenueRepository venueRepository;

    @Override
    public List<Venue> getAllVenue() {
        return (List<Venue>)venueRepository.findAll();
    }

    @Override
    public Venue getVenueById(Integer id) {
        return venueRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Venue venue) {
        venueRepository.save(venue);
    }

    @Override
    public void delete(Integer id) {
        venueRepository.deleteById(id);
    }
}
