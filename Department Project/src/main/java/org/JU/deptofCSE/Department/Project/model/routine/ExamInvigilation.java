package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ExamInvigilation")
public class ExamInvigilation {

    @Id
    @Column(name = "examId")
    private Integer examId;

    @Column(name = "invigilator1")
    private Integer invigilator1;

    @Column(name = "invigilator2")
    private Integer invigilator2;

    @Column(name = "invigilator3")
    private Integer invigilator3;

    @Column(name = "invigilator4")
    private Integer invigilator4;

    @Column(name = "invigilator5")
    private Integer invigilator5;

    @Column(name = "invigilator6")
    private Integer invigilator6;

    @Column(name = "invigilator7")
    private Integer invigilator7;

    @Column(name = "invigilator8")
    private Integer invigilator8;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getInvigilator1() {
        return invigilator1;
    }

    public void setInvigilator1(Integer invigilator1) {
        this.invigilator1 = invigilator1;
    }

    public Integer getInvigilator2() {
        return invigilator2;
    }

    public void setInvigilator2(Integer invigilator2) {
        this.invigilator2 = invigilator2;
    }

    public Integer getInvigilator3() {
        return invigilator3;
    }

    public void setInvigilator3(Integer invigilator3) {
        this.invigilator3 = invigilator3;
    }

    public Integer getInvigilator4() {
        return invigilator4;
    }

    public void setInvigilator4(Integer invigilator4) {
        this.invigilator4 = invigilator4;
    }

    public Integer getInvigilator5() {
        return invigilator5;
    }

    public void setInvigilator5(Integer invigilator5) {
        this.invigilator5 = invigilator5;
    }

    public Integer getInvigilator6() {
        return invigilator6;
    }

    public void setInvigilator6(Integer invigilator6) {
        this.invigilator6 = invigilator6;
    }

    public Integer getInvigilator7() {
        return invigilator7;
    }

    public void setInvigilator7(Integer invigilator7) {
        this.invigilator7 = invigilator7;
    }

    public Integer getInvigilator8() {
        return invigilator8;
    }

    public void setInvigilator8(Integer invigilator8) {
        this.invigilator8 = invigilator8;
    }

    @Override
    public String toString() {
        return "ExamInvigilation{" +
                "examId=" + examId +
                ", invigilator1=" + invigilator1 +
                ", invigilator2=" + invigilator2 +
                ", invigilator3=" + invigilator3 +
                ", invigilator4=" + invigilator4 +
                ", invigilator5=" + invigilator5 +
                ", invigilator6=" + invigilator6 +
                ", invigilator7=" + invigilator7 +
                ", invigilator8=" + invigilator8 +
                '}';
    }
}
