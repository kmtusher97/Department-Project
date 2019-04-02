package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.TeacherAvailability;

import java.util.Date;
import java.util.List;

public interface TeacherAvailabilityServices {

    public List<TeacherAvailability> getAllTeacherAvailability();
    public TeacherAvailability getTeacherAvailability(Date date);
    public void saveOrUpdate(TeacherAvailability teacherAvailability);
    public void delete(Date date);
}
