package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Routine;
import org.JU.deptofCSE.Department.Project.repository.routine.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoutineServicesImplementation implements RoutineServices {

    @Autowired
    RoutineRepository routineRepository;

    @Override
    public List<Routine> getAllRoutine() {
        return (List<Routine>)routineRepository.findAll();
    }

    @Override
    public Routine getRoutineById(Integer id) {
        return routineRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Routine routine) {
        routineRepository.save(routine);
    }

    @Override
    public void delete(Integer id) {
        routineRepository.deleteById(id);
    }
}
