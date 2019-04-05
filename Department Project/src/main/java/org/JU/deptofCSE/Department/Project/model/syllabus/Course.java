package org.JU.deptofCSE.Department.Project.model.syllabus;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Course")
public class Course {

    private String courseCode;

    private String courseTitle;

    private String courseType;

    private Integer courseCredit;

    private String rational;

    private CourseObjectives courseObjectives;

    private LearningOutcomes learningOutcomes;

    private CourseDescriptions courseDescriptions;

    private Books books;




    @XmlElement(name = "CourseCode")
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @XmlElement(name = "CourseTitle")
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @XmlElement(name = "CourseType")
    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @XmlElement(name = "CourseCredit")
    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    @XmlElement(name = "Rational")
    public String getRational() {
        return rational;
    }

    public void setRational(String rational) {
        this.rational = rational;
    }

    @XmlElement(name = "CourseObjectives")
    public CourseObjectives getCourseObjectives() {
        return courseObjectives;
    }

    public void setCourseObjectives(CourseObjectives courseObjectives) {
        this.courseObjectives = courseObjectives;
    }

    public void addNewCourseObjective(CourseObjective courseObjective) {
        if(this.courseObjectives == null) {
            this.courseObjectives = new CourseObjectives();
        }
        this.courseObjectives.addCourseObjective(courseObjective);
    }

    @XmlElement(name = "LearningOutcomes")
    public LearningOutcomes getLearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(LearningOutcomes learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    @XmlElement(name = "CourseDescriptions")
    public CourseDescriptions getCourseDescriptions() {
        return courseDescriptions;
    }

    public void setCourseDescriptions(CourseDescriptions courseDescriptions) {
        this.courseDescriptions = courseDescriptions;
    }

    @XmlElement(name = "Books")
    public Books getBooks() {
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
