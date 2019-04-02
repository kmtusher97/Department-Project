package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Exam;

import java.util.List;

public interface ExamServices {

    public List<Exam> getAllExam();
    public Exam getExamById(Integer id);
    public void saveOrUpdate(Exam exam);
    public void delate(Integer id);
}
