package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Admin;

import java.util.List;

public interface AdminServices {
    public List<Admin> getAllAdmin();
    public Admin getAdminById(Integer id);
    public void saveOrUpdate(Admin admin);
    public void delate(Integer id);
}
