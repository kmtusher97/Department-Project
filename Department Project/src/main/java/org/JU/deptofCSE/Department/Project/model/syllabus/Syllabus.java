package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Syllabus")
public class Syllabus {

    private Integer effictiveFrom;

    private Integer effictiveTo;

    private String category;

    private Semesters semesters;

    public Syllabus() {
        this.effictiveFrom = 0;
        this.effictiveTo = 0;
        this.category = "";
        this.semesters = new Semesters();
    }

    public Syllabus(Integer effictiveFrom, Integer effictiveTo, String category, Semesters semesters) {
        this.effictiveFrom = effictiveFrom;
        this.effictiveTo = effictiveTo;
        this.category = category;
        this.semesters = semesters;
    }

    @XmlElement(name = "EffictiveFrom")
    public Integer getEffictiveFrom() {
        return effictiveFrom;
    }

    public void setEffictiveFrom(Integer effictiveFrom) {
        this.effictiveFrom = effictiveFrom;
    }

    @XmlElement(name = "EffictiveTo")
    public Integer getEffictiveTo() {
        return effictiveTo;
    }

    public void setEffictiveTo(Integer effictiveTo) {
        this.effictiveTo = effictiveTo;
    }

    @XmlElement(name = "Category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement(name = "Semesters")
    public Semesters getSemesters() {
        return semesters;
    }

    public void setSemesters(Semesters semesters) {
        this.semesters = semesters;
    }



    public Integer countOfSemesters() {
        if(this.semesters == null) {
            this.semesters = new Semesters();
            this.semesters.setSemesters(new ArrayList<Semester>());
        }
        return this.semesters.getSemesters().size();
    }

    public Integer getNumberOfsemisters() {
        if(this.category.equals("Undergrad")) {
            return 8;
        }
        else if(this.category.equals("Masters")) {
            return 4;
        }
        else if(this.category.equals("PMSCS")) {
            return 4;
        }
        else if(this.category.equals("MPhil")) {
            return 4;
        }
        else if(this.category.equals("Phd")) {
            return 6;
        }
        return 0;
    }

    public String makeXmlFileName() {
        return this.category + "_" + Integer.toString(this.effictiveFrom)
                + "to" + Integer.toString(this.getEffictiveTo() % 100);
    }

    public void addNewSemester(Semester semester) {
        if(this.semesters == null) {
            this.semesters = new Semesters();
        }
        this.semesters.addSemester(semester);
    }

    public void addNewCourse(Course course, String semesterName) {
        this.semesters.addCourse(course, semesterName);
    }

    @Override
    public String toString() {
        return "Syllabus{" +
                "effictiveFrom=" + effictiveFrom +
                ", effictiveTo=" + effictiveTo +
                ", category='" + category + '\'' +
                ", semesters=" + semesters +
                '}';
    }
}
