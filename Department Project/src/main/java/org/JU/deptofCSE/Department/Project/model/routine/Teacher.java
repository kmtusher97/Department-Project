package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    private Integer id;

    @Column(name = "fullName", length = 200)
    private String fullName;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "mobileNo1", length = 11)
    private String mobileNo1;

    @Column(name = "mobileNo2", length = 11)
    private String mobileNo2;

    @Column(name = "campusResident")
    private boolean campusResident;

    @Column(name = "joiningDate")
    private Date joiningDate;

    @Column(name = "numberOfCommitteeAsChairman")
    private Integer numberOfCommitteeAsChairman;

    @Column(name = "numberOfCommitteeAsMember")
    private Integer numberOfCommitteeAsMember;

    /**
     * has one to one relation with user
     * has common primary key (userId)
     */
    @OneToOne
    @MapsId
    private User user;

    public Teacher() {}

    public Teacher(User user) {
        this.user = user;
    }

    public Teacher(Integer id, String fullName, String designation,
                   String mobileNo1, String mobileNo2, boolean campusResident,
                   Date joiningDate, Integer numberOfCommitteeAsChairman,
                   Integer numberOfCommitteeAsMember, User user) {
        this.id = id;
        this.fullName = fullName;
        this.designation = designation;
        this.mobileNo1 = mobileNo1;
        this.mobileNo2 = mobileNo2;
        this.campusResident = campusResident;
        this.joiningDate = joiningDate;
        this.numberOfCommitteeAsChairman = numberOfCommitteeAsChairman;
        this.numberOfCommitteeAsMember = numberOfCommitteeAsMember;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
