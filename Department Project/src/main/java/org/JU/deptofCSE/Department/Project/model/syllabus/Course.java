package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Course")
public class Course {

    @XmlElement(name = "CourseCode")
    private String courseCode;

    @XmlElement(name = "CourseTitle")
    private String courseTitle;

    @XmlElement(name = "CourseType")
    private String courseType;

    @XmlElement(name = "Rational")
    private String rational;


    @XmlElement(name = "CourseDescriptions")
    private CourseDescriptions courseDescriptions;

    @XmlElement(name = "Books")
    private Books books;




}
