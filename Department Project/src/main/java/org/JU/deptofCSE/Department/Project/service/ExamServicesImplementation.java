package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Exam;
import org.JU.deptofCSE.Department.Project.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamServicesImplementation implements ExamServices {

    @Autowired
    ExamRepository examRepository;


    @Override
    public List<Exam> getAllExam() {
        return (List<Exam>)examRepository.findAll();
    }

    @Override
    public Exam getExamById(Integer id) {
        return examRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void delate(Integer id) {
        examRepository.deleteById(id);
    }
}
