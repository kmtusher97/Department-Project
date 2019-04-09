package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.VenueAvailability;
import org.JU.deptofCSE.Department.Project.repository.routine.VenueAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class VenueAvailabilityServicesImplementation implements VenuAvailabilityServices {

    @Autowired
    VenueAvailabilityRepository venueAvailabilityRepository;

    @Override
    public List<VenueAvailability> getAllVenueAvailability() {
        return (List<VenueAvailability>)venueAvailabilityRepository.findAll();
    }

    @Override
    public VenueAvailability getVenueAvailabilityByDate(Date date) {
        return venueAvailabilityRepository.getOne(date);
    }

    @Override
    public void saveOrUpdate(VenueAvailability venueAvailability) {
        venueAvailabilityRepository.save(venueAvailability);
    }

    @Override
    public void delete(Date date) {
        venueAvailabilityRepository.deleteById(date);
    }
}
