package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AssignedInvigilation")
public class AssignedInvigilation {

    @Id
    @Column(name = "userId")
    private Integer id;

    @Column(name = "countOfInvigilation")
    private Integer countOfInvigilation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOfInvigilation() {
        return countOfInvigilation;
    }

    public void setCountOfInvigilation(Integer countOfInvigilation) {
        this.countOfInvigilation = countOfInvigilation;
    }

    @Override
    public String toString() {
        return "AssignedInvigilation{" +
                "id=" + id +
                ", countOfInvigilation=" + countOfInvigilation +
                '}';
    }
}
