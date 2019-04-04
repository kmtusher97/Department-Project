package org.JU.deptofCSE.Department.Project.model.syllabus;

import java.util.List;

public class Course {

    private String code;

    private String title;

    private String type;

    private String rational;

    private List<String> objectives;

    private List<String> learningOutcomes;

    private CourseDescriptions courseDescriptions;

    private Books books;

    public String get_Code() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String get_Title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_Type() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String get_Rational() {
        return rational;
    }

    public void setRational(String rational) {
        this.rational = rational;
    }

    public List<String> get_Objectives() {
        return objectives;
    }

    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    public List<String> get_LearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(List<String> learningOutcomes) {
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
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", rational='" + rational + '\'' +
                ", objectives=" + objectives +
                ", learningOutcomes=" + learningOutcomes +
                ", courseDescriptions=" + courseDescriptions +
                ", books=" + books +
                '}';
    }
}
