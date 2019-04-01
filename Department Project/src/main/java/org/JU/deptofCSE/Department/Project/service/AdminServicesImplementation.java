package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.Admin;
import org.JU.deptofCSE.Department.Project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServicesImplementation implements AdminServices {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmin() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void delate(Integer id) {
        adminRepository.deleteById(id);
    }
}
