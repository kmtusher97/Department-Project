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

    @XmlElement(name = "CourseCredit")
    private Integer courseCredit;

    @XmlElement(name = "Rational")
    private String rational;

    @XmlElement(name = "CourseObjectives")
    private CourseObjectives courseObjectives;

    @XmlElement(name = "LearningOutcomes")
    private LearningOutcomes learningOutcomes;

    @XmlElement(name = "CourseDescriptions")
    private CourseDescriptions courseDescriptions;

    @XmlElement(name = "Books")
    private Books books;


    public String get_CourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String get_CourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String get_CourseType() {
        return courseType;
    }

    public Integer get_CourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String get_Rational() {
        return rational;
    }

    public void setRational(String rational) {
        this.rational = rational;
    }

    public CourseObjectives get_CourseObjectives() {
        return courseObjectives;
    }

    public void setCourseObjectives(CourseObjectives courseObjectives) {
        this.courseObjectives = courseObjectives;
    }

    public LearningOutcomes get_LearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(LearningOutcomes learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    public CourseDescriptions get_CourseDescriptions() {
        return courseDescriptions;
    }

    public void setCourseDescriptions(CourseDescriptions courseDescriptions) {
        this.courseDescriptions = courseDescriptions;
    }

    public Books get_Books() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseCredit=" + courseCredit +
                ", rational='" + rational + '\'' +
                ", courseObjectives=" + courseObjectives +
                ", learningOutcomes=" + learningOutcomes +
                ", courseDescriptions=" + courseDescriptions +
                ", books=" + books +
                '}';
    }
}
