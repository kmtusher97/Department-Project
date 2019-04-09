package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.AssignedInvigilation;
import org.JU.deptofCSE.Department.Project.repository.routine.AssignedInvigilationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignedInvigilationServicesImplementation implements AssignedInvigilationServices{

    @Autowired
    AssignedInvigilationRepository assignedInvigilationRepository;


    @Override
    public List<AssignedInvigilation> getAllAssignedInvigilation() {
        return (List<AssignedInvigilation>) assignedInvigilationRepository.findAll();
    }

    @Override
    public AssignedInvigilation getAssignedInvigilationById(Integer id) {
        return assignedInvigilationRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(AssignedInvigilation assignedInvigilation) {
        assignedInvigilationRepository.save(assignedInvigilation);
    }

    @Override
    public void delate(Integer id) {
        assignedInvigilationRepository.deleteById(id);
    }
}
