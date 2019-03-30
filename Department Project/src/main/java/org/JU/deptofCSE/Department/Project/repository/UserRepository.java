package org.JU.deptofCSE.Department.Project.repository;

import org.JU.deptofCSE.Department.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}