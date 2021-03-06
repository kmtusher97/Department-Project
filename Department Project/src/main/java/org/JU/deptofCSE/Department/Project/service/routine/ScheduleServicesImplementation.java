package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Schedule;
import org.JU.deptofCSE.Department.Project.repository.routine.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleServicesImplementation implements ScheduleServices {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedule() {
        return (List<Schedule>)scheduleRepository.findAll();
    }

    @Override
    public Schedule getTeacherAvailability(Integer id) {
        return scheduleRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void delete(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
