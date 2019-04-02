package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Routine;

import java.util.List;

public interface RoutineServices {

    public List<Routine> getAllRoutine();
    public Routine getRoutineById(Integer id);
    public void saveOrUpdate(Routine routine);
    public void delete(Integer id);
}
