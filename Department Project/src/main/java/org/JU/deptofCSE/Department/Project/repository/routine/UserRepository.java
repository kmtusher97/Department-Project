package org.JU.deptofCSE.Department.Project.repository.routine;

import org.JU.deptofCSE.Department.Project.model.routine.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
