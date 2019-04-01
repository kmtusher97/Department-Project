package org.JU.deptofCSE.Department.Project.model;

import javax.persistence.*;
import java.time.Year;


@Entity
@Table(name = "ExamCommittee")
public class ExamCommittee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examId")
    private Integer examId;

    @Column(name = "chairman")
    private Integer chairman;

    @Column(name = "member1")
    private Integer member1;

    @Column(name = "member2")
    private Integer member2;

    @Column(name = "member3")
    private Integer member3;

    @Column(name = "session")
    private String session;

    @Column(name = "year")
    private Integer year;

    @Column(name = "numberOfStudent")
    private Integer numberOfStudent;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getChairman() {
        return chairman;
    }

    public void setChairman(Integer chairman) {
        this.chairman = chairman;
    }

    public Integer getMember1() {
        return member1;
    }

    public void setMember1(Integer member1) {
        this.member1 = member1;
    }

    public Integer getMember2() {
        return member2;
    }

    public void setMember2(Integer member2) {
        this.member2 = member2;
    }

    public Integer getMember3() {
        return member3;
    }

    public void setMember3(Integer member3) {
        this.member3 = member3;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(Integer numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    @Override
    public String toString() {
        return "ExamCommittee{" +
                "examId=" + examId +
                ", chairman=" + chairman +
                ", member1=" + member1 +
                ", member2=" + member2 +
                ", member3=" + member3 +
                ", session='" + session + '\'' +
                ", year=" + year +
                ", numberOfStudent=" + numberOfStudent +
                '}';
    }
}
