package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Admin;

import java.util.List;

public interface AdminServices {
    public List<Admin> getAllAdmin();
    public Admin getAdminById(Integer id);
    public void saveOrUpdate(Admin admin);
    public void delate(Integer id);
}
