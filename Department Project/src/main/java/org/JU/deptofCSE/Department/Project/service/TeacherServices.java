package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Teacher;

import java.util.List;

public interface TeacherServices {

    public List<Teacher> getAllTeacher();
    public Teacher getTeacher(Integer id);
    public void saveOrUpdate(Teacher teacher);
    public void delete(Integer id);
}
