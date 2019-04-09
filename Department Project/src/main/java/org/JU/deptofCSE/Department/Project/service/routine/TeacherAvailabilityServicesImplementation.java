package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.TeacherAvailability;
import org.JU.deptofCSE.Department.Project.repository.routine.TeacherAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TeacherAvailabilityServicesImplementation implements TeacherAvailabilityServices {

    @Autowired
    TeacherAvailabilityRepository teacherAvailabilityRepository;

    @Override
    public List<TeacherAvailability> getAllTeacherAvailability() {
        return (List<TeacherAvailability>)teacherAvailabilityRepository.findAll();
    }

    @Override
    public TeacherAvailability getTeacherAvailability(Date date) {
        return teacherAvailabilityRepository.getOne(date);
    }

    @Override
    public void saveOrUpdate(TeacherAvailability teacherAvailability) {
        teacherAvailabilityRepository.save(teacherAvailability);
    }

    @Override
    public void delete(Date date) {
        teacherAvailabilityRepository.deleteById(date);
    }
}
