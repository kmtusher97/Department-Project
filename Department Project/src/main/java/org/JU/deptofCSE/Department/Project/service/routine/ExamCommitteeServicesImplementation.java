package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.ExamCommittee;
import org.JU.deptofCSE.Department.Project.repository.routine.ExamCommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamCommitteeServicesImplementation implements ExamCommitteeServices {

    @Autowired
    ExamCommitteeRepository examCommitteeRepository;


    @Override
    public List<ExamCommittee> getAllExamCommittee() {
        return (List<ExamCommittee>)examCommitteeRepository.findAll();
    }

    @Override
    public ExamCommittee getExamCommitteeById(Integer id) {
        return examCommitteeRepository.getOne(id);
    }

    @Override
    public void saveOrDelate(ExamCommittee examCommittee) {
        examCommitteeRepository.save(examCommittee);
    }

    @Override
    public void delate(Integer id) {
        examCommitteeRepository.deleteById(id);
    }
}
