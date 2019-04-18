package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    private Integer id;

    @Column(name = "fullName", unique = false, length = 200, nullable = false)
    private String fullName;

    /**
     * has one to one relationship with user
     * have common primary key
     */
    @OneToOne
    @JoinColumn
    @MapsId
    private User user;

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
