package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "routineId")
    private Integer routineId;

    @Column(name = "date")
    private Date date;

    @Column(name = "examId")
    private Integer examId;

    @Column(name = "venueId")
    private Integer venueId;

    @Column(name = "scheduleId")
    private Integer scheduleId;

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "routineId=" + routineId +
                ", date=" + date +
                ", examId=" + examId +
                ", venueId=" + venueId +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
