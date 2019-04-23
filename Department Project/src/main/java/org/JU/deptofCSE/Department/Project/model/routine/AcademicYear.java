package org.JU.deptofCSE.Department.Project.model.routine;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Table(name = "AcademicYear")
public class AcademicYear {

    @Id
    private Integer year;

    public AcademicYear() {
    }

    public AcademicYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "AcademicYear{" +
                "year=" + year +
                '}';
    }

    public LocalDate getFirstDate() {
        return LocalDate.of(year, Month.JANUARY, 1);
    }

    public LocalDate getLastDate() {
        return LocalDate.of(year, Month.DECEMBER, 31);
    }
}
