package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Routine;

import java.util.List;

public interface RoutineServices {

    public List<Routine> getAllRoutine();
    public Routine getRoutineById(Integer id);
    public void saveOrUpdate(Routine routine);
    public void delete(Integer id);
}
