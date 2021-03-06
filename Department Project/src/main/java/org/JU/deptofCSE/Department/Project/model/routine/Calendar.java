package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Calendar")
public class Calendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "date")
    private Date date;

    @Column(name = "day")
    private String day;

    @Column(name = "vacationStatus")
    private Integer vacationStatus;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(Integer vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "date=" + date +
                ", day='" + day + '\'' +
                ", vacationStatus=" + vacationStatus +
                '}';
    }

}
