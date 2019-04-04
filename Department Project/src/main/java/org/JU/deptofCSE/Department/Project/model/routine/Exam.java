package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examId")
    private Integer examId;

    @Column(name = "date")
    private Date date;

    @Column(name = "year")
    private Integer year;

    @Column(name = "session")
    private String session;

    @Column(name = "veniueId")
    private Integer veniueId;

    @Column(name = "scheduleId")
    private Integer scheduleId;


    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getVeniueId() {
        return veniueId;
    }

    public void setVeniueId(Integer veniueId) {
        this.veniueId = veniueId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", date=" + date +
                ", year=" + year +
                ", session='" + session + '\'' +
                ", veniueId=" + veniueId +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
