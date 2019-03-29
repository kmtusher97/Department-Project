package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.User;

import java.util.List;

public interface UserServices {

    public List<User> getAllUser();
    public User getUserByID(Integer id);
    public User getByEmail(String email);
    public void saveOrUpdateUser(User user);
    public void deleteUser(Integer id);
}
