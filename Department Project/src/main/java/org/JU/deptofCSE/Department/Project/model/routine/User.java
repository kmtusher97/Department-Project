package org.JU.deptofCSE.Department.Project.model.routine;


import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    @Column(name = "email", unique = true, length = 200, nullable = false)
    private String email;

    @Column(name = "password", unique = false, length = 50, nullable = false)
    private String password;

    /**
     * has one to one relationship with admin
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin admin;

    /**
     * has one to one relationship with teacher
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
