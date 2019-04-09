package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Schedule;

import java.util.List;

public interface ScheduleServices {

    public List<Schedule> getAllSchedule();
    public Schedule getTeacherAvailability(Integer id);
    public void saveOrUpdate(Schedule schedule);
    public void delete(Integer id);
}
