package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.ExamCommittee;

import java.util.List;

public interface ExamCommitteeServices {
    public List<ExamCommittee> getAllExamCommittee();
    public ExamCommittee getExamCommitteeById(Integer id);
    public void saveOrDelate(ExamCommittee examCommittee);
    public void delate(Integer id);
}
