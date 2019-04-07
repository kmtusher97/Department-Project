package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Teacher;

import java.util.List;

public interface TeacherServices {

    public List<Teacher> getAllTeacher();
    public Teacher getTeacherById(Integer id);
    public void saveOrUpdate(Teacher teacher);
    public void delete(Integer id);
}
