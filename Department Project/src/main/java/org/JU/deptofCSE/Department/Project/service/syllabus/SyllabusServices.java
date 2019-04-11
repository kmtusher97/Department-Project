package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Courses;
import org.JU.deptofCSE.Department.Project.model.syllabus.Semester;
import org.JU.deptofCSE.Department.Project.model.syllabus.Semesters;
import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.repository.syllabus.SyllabusRepository;

import javax.xml.bind.JAXBException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SyllabusServices {

    SyllabusRepository syllabusRepository = new SyllabusRepository();

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        return syllabusRepository.getSyllabus(fileName);
    }

    public void saveSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        syllabusRepository.addSyllabus(syllabus, fileName);
    }

    public boolean isTheSyllabusExists(String fileName) throws JAXBException {
        return (syllabusRepository.getSyllabus(fileName) != null);
    }

    public Syllabus removeSemester(String semesterName, Syllabus syllabus) {
        Set<Semester> semesterSet = syllabus.getSemesters().getSemesters();
        for(Semester semester : semesterSet) {
            if(!semester.getName().equals(semesterName)) {
                continue;
            }
            semesterSet.remove(semester);
            break;
        }
        Semesters semesters = syllabus.getSemesters();
        semesters.setSemesters((TreeSet<Semester>) semesterSet);
        syllabus.setSemesters(semesters);
        return syllabus;
    }

    public SortedSet<String> getAllSyllabusFileNames() {                     // get all the names of the stored syllabuses
        return syllabusRepository.getAllSyllabusNames();
    }

    public Courses getCoursesOfASemesterBy(String semesterName, String fileName) throws JAXBException {   // get the courses of a semester
        Syllabus syllabus = syllabusRepository.getSyllabus(fileName);
        SortedSet<Semester> semesters = syllabus.getSemesters().getSemesters();
        for(Semester semester :semesters) {
            if(semester.getName().equals(semesterName)) {
                return semester.getCourses();
            }
        }
        return null;
    }

    public void deleteSyllabus(String fileName) {                            // delete a syllabus from xml repository
        syllabusRepository.deleteSyllabus(fileName);
    }

}
