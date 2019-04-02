package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.ExamInvigilation;

import java.util.List;

public interface ExamInvigilationServices {

    public List<ExamInvigilation> getAllRoutine();
    public ExamInvigilation getRoutineById(Integer id);
    public void saveOrUpdate(ExamInvigilation examInvigilation);
    public void delete(Integer id);
}
