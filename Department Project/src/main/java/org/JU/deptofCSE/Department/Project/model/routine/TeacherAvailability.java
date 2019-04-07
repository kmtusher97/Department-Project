package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TeacherAvailability")
public class TeacherAvailability {

    @Id
    @Column(name = "date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TeacherAvailability{" +
                "date=" + date +
                '}';
    }
}
