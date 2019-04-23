package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Calendar")
public class Calendar implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "day")
    private String day;

    @Column(name = "vacationStatus")
    private Integer vacationStatus;

    public Calendar() {
    }

    public Calendar(LocalDate date) {
        this.date = date;
        this.day = date.getDayOfWeek().toString();
        this.vacationStatus = (this.day.equals("FRIDAY") || this.day.equals("SATURDAY")) ? 1 : 0;
    }

    public Calendar(LocalDate date, String day, Integer vacationStatus) {
        this.date = date;
        this.day = day;
        this.vacationStatus = vacationStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
