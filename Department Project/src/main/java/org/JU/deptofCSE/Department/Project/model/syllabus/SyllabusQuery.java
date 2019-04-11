package org.JU.deptofCSE.Department.Project.model.syllabus;

public class SyllabusQuery {

    private String category;

    private Integer from;

    private Integer to;

    private Integer year;

    private Integer semester;

    private String courseCode;

    public SyllabusQuery() {
        this.category = "";
        this.from = 0;
        this.to = 0;
        this.year = 0;
        this.semester = 0;
        this.courseCode = "";
    }

    public SyllabusQuery(String category, Integer from, Integer to, Integer year, Integer semester, String courseCode) {
        this.category = category;
        this.from = from;
        this.to = to;
        this.year = year;
        this.semester = semester;
        this.courseCode = courseCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "SyllabusQuery{" +
                "category='" + category + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", year=" + year +
                ", semester=" + semester +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

    public int getSemesterNoByYearAndSemester() {
        int ret = 0;

        if(this.category == "Undergrad" || this.category == "Masters") {
            ret = this.year * (this.semester + (this.semester % 2));
            ret -= (this.semester % 2);
        }
        else if(this.category == "Phd") {                                       // future addition

        }
        return ret;
    }

}
