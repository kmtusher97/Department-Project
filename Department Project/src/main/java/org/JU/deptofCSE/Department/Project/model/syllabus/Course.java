package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Course")
public class Course {

    private String courseCode;

    private String courseTitle;

    private String courseType;

    private double courseCredit;

    private String rational;

    private CourseObjectives courseObjectives;

    private LearningOutcomes learningOutcomes;

    private CourseDescriptions courseDescriptions;

    private LaboratoryRequirements laboratoryRequirements;

    private Books books;


    public Course() {
        this.courseCode = "";
        this.courseTitle = "";
        this.courseType = "";
        this.courseCredit = 0.0;
        this.rational = "";
        this.courseObjectives = new CourseObjectives();
        this.learningOutcomes = new LearningOutcomes();
        this.courseDescriptions = new CourseDescriptions();
        this.laboratoryRequirements = new LaboratoryRequirements();
        this.books = new Books();
    }

    public Course(String courseCode, String courseTitle,
                  String courseType, Float courseCredit, String rational,
                  CourseObjectives courseObjectives, LearningOutcomes learningOutcomes,
                  CourseDescriptions courseDescriptions,
                  LaboratoryRequirements laboratoryRequirements, Books books) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseCredit = courseCredit;
        this.rational = rational;
        this.courseObjectives = courseObjectives;
        this.learningOutcomes = learningOutcomes;
        this.courseDescriptions = courseDescriptions;
        this.laboratoryRequirements = laboratoryRequirements;
        this.books = books;
    }

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
    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
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

    @XmlElement(name = "LaboratoryRequirements")
    public LaboratoryRequirements getLaboratoryRequirements() {
        return laboratoryRequirements;
    }

    public void setLaboratoryRequirements(LaboratoryRequirements laboratoryRequirements) {
        this.laboratoryRequirements = laboratoryRequirements;
    }

    @XmlElement(name = "Books")
    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }


    public void addNewBook(Book book) {
        if(this.books == null) {
            this.books = new Books();
        }
        this.books.addBook(book);
    }

    public void addNewCourseDescription(CourseDescription courseDescription) {
        if(this.courseDescriptions == null) {
            this.courseDescriptions = new CourseDescriptions();
        }
        this.courseDescriptions.addCourseDescription(courseDescription);
    }

    public void addNewLearningOutcome(LearningOutcome learningOutcome) {
        if(this.learningOutcomes == null) {
            this.learningOutcomes = new LearningOutcomes();
        }
        this.learningOutcomes.addLearningOutcome(learningOutcome);
    }

    public void addNewCourseObjective(CourseObjective courseObjective) {
        if(this.courseObjectives == null) {
            this.courseObjectives = new CourseObjectives();
        }
        this.courseObjectives.addCourseObjective(courseObjective);
    }

    public void addNewLaboratoryRequirement(LaboratoryRequirement laboratoryRequirement) {
        if(this.laboratoryRequirements == null) {
            this.laboratoryRequirements = new LaboratoryRequirements();
        }
        this.laboratoryRequirements.addLaboratoryRequirement(laboratoryRequirement);
    }

    public Integer getCountOfBooks() {
        return this.books.getCount();
    }

    public Integer getCountOfCourseDescriptions() {
        return this.courseDescriptions.getCount();
    }

    public Integer getCountOfLearningOutComes() {
        return this.learningOutcomes.getCount();
    }

    public Integer getCountOfCourseObjectives() {
        return this.courseObjectives.getCount();
    }

    public Integer getCountOfLaboratoryRequirements() {
        return  this.laboratoryRequirements.getCount();
    }


    public Integer getCourseCodeNumber() {
        Integer codeNumner = 0, powerOf10 = 1;
        for(int i = this.courseCode.length() - 1; i >= 0; i--) {
            char ch = this.courseCode.charAt(i);
            if(ch >= '0' && ch <= '9') {
                codeNumner += ((ch - '0') * powerOf10);
                powerOf10 *= 10;
            }
            else {
                break;
            }
        }
        return codeNumner;
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
