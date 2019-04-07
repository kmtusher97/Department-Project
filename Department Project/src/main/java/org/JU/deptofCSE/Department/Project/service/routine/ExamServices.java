package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Exam;

import java.util.List;

public interface ExamServices {

    public List<Exam> getAllExam();
    public Exam getExamById(Integer id);
    public void saveOrUpdate(Exam exam);
    public void delate(Integer id);
}
