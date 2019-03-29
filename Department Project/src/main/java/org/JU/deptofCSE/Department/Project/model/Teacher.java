package org.JU.deptofCSE.Department.Project.model;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
