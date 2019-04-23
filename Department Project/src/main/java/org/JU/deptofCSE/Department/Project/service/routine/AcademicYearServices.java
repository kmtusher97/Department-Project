package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.AcademicYear;

import java.util.List;

public interface AcademicYearServices {

    public List<AcademicYear> getAllAcademicYears();

    public AcademicYear getAcademicYear(Integer year);

    public void saveAcademicYear(AcademicYear academicYear);

    public void deleteAcademicYear(Integer year);
}
