package org.JU.deptofCSE.Department.Project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "mobileNo1")
    private String mobileNo1;

    @Column(name = "mobileNo2")
    private String mobileNo2;

    @Column(name = "campusResident")
    private boolean campusResident;

    @Column(name = "joiningDate")
    private Date joiningDate;

    @Column(name = "numberOfCommitteeAsChairman")
    private Integer numberOfCommitteeAsChairman;

    @Column(name = "numberOfCommitteeAsMember")
    private Integer numberOfCommitteeAsMember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileNo1() {
        return mobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        this.mobileNo1 = mobileNo1;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public boolean isCampusResident() {
        return campusResident;
    }

    public void setCampusResident(boolean campusResident) {
        this.campusResident = campusResident;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Integer getNumberOfCommitteeAsChairman() {
        return numberOfCommitteeAsChairman;
    }

    public void setNumberOfCommitteeAsChairman(Integer numberOfCommitteeAsChairman) {
        this.numberOfCommitteeAsChairman = numberOfCommitteeAsChairman;
    }

    public Integer getNumberOfCommitteeAsMember() {
        return numberOfCommitteeAsMember;
    }

    public void setNumberOfCommitteeAsMember(Integer numberOfCommitteeAsMember) {
        this.numberOfCommitteeAsMember = numberOfCommitteeAsMember;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", designation='" + designation + '\'' +
                ", mobileNo1='" + mobileNo1 + '\'' +
                ", mobileNo2='" + mobileNo2 + '\'' +
                ", campusResident=" + campusResident +
                ", joiningDate=" + joiningDate +
                ", numberOfCommitteeAsChairman=" + numberOfCommitteeAsChairman +
                ", numberOfCommitteeAsMember=" + numberOfCommitteeAsMember +
                '}';
    }
}
