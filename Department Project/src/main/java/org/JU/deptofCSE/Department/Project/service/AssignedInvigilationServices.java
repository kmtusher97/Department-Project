package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.AssignedInvigilation;

import java.util.List;

public interface AssignedInvigilationServices {
    public List<AssignedInvigilation> getAllAssignedInvigilation();
    public AssignedInvigilation getAssignedInvigilationById(Integer id);
    public void saveOrUpdate(AssignedInvigilation assignedInvigilation);
    public void delate(Integer id);
}
