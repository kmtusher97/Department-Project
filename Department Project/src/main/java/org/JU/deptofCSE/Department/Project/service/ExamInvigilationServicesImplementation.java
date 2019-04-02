package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.ExamInvigilation;
import org.JU.deptofCSE.Department.Project.repository.ExamInvigilationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamInvigilationServicesImplementation implements ExamInvigilationServices {

    @Autowired
    ExamInvigilationRepository examInvigilationRepository;

    @Override
    public List<ExamInvigilation> getAllRoutine() {
        return (List<ExamInvigilation>)examInvigilationRepository.findAll();
    }

    @Override
    public ExamInvigilation getRoutineById(Integer id) {
        return examInvigilationRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(ExamInvigilation examInvigilation) {
        examInvigilationRepository.save(examInvigilation);
    }

    @Override
    public void delete(Integer id) {
        examInvigilationRepository.deleteById(id);
    }
}
