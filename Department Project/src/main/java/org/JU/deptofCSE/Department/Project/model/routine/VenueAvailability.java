package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VenueAvailability")
public class VenueAvailability {

    @Id
    @Column(name = "date")
    private Date date;

    @Column(name = "venueId")
    private Integer venueId;

    @Column(name = "scheduleId")
    private Integer scheduleId;

    @Column(name = "examId")
    private Integer examId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    @Override
    public String toString() {
        return "VenueAvailability{" +
                "date=" + date +
                ", venueId=" + venueId +
                ", scheduleId=" + scheduleId +
                ", examId=" + examId +
                '}';
    }
}
