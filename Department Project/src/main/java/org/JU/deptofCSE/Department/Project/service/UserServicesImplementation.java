package org.JU.deptofCSE.Department.Project.service;

import org.JU.deptofCSE.Department.Project.model.User;
import org.JU.deptofCSE.Department.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicesImplementation implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User getUserByID(Integer id) {
        return userRepository.getOne(id);
    }

    /*@Override
    public User getUserByEmail(String email) {
        return null;
    }*/

    @Override
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
